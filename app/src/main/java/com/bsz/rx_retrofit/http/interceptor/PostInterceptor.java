package com.bsz.rx_retrofit.http.interceptor;

import com.bsz.dao.CookieInfo;
import com.bsz.rx_retrofit.http.dbutil.CookieDbUtil;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

/**
 * 数据缓存拦截器，用于做数据缓存。
 * 如果在设置的缓存时间内，缓存不为null，则不会再次请求同一地址资源
 * Created by sunyan on 16/12/7.
 */
public class PostInterceptor implements Interceptor {
    private CookieDbUtil dbUtil;
    private boolean cache;//是否缓存
    public PostInterceptor(Boolean iscache){
        dbUtil = CookieDbUtil.getInstance();
        this.cache = iscache;
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        if(cache){
            ResponseBody body = response.body();
            BufferedSource source = body.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();
            Charset charset = Charset.defaultCharset();
            MediaType contentType = body.contentType();
            if (contentType != null) {
                charset = contentType.charset(charset);
            }
            String bodyString = buffer.clone().readString(charset);//访问到的内容
            String url = request.url().toString();//资源地址
            CookieInfo result = dbUtil.queryCookieBy(url);
            long time=System.currentTimeMillis();
            /*保存和更新本地数据*/
            if(result==null){
                result  =new CookieInfo(url,bodyString,time);
                dbUtil.saveCookie(result);
            }else{
                result.setResult(bodyString);
                result.setTime(time);
                dbUtil.updateCookie(result);
            }
        }
        return response;
    }
}
