package com.bsz.rx_retrofit.http;

import com.bsz.rx_retrofit.api.BaseApi;
import com.bsz.rx_retrofit.http.interceptor.CacheInterceptor;
import com.bsz.rx_retrofit.http.interceptor.PostInterceptor;
import com.bsz.rx_retrofit.subscriber.ProgressSubscriber;
import com.bsz.util.UIUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * RxJava+retrofit网络请求管理类
 * Created by sunyan on 16/12/7.
 */
public class HttpManager {
    private static HttpManager httpManager;
    public synchronized static HttpManager getInstance(){
        if (httpManager == null){
            httpManager = new HttpManager();
        }
        return httpManager;
    }

    /**
     * 网络请求
     * @param baseApi
     */
    public void getHttpResult(BaseApi baseApi) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(baseApi.getConnectionTime(), TimeUnit.SECONDS);
        builder.addInterceptor(new PostInterceptor(baseApi.isCache()));
        builder.addNetworkInterceptor(new CacheInterceptor());
         /*缓存位置和大小*/
        builder.cache(new Cache(UIUtils.getContext().getCacheDir(), 10 * 1024 * 1024));

        /*创建retrofit对象*/
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(baseApi.getBaseUrl())
                .build();
        HttpService httpService = retrofit.create(HttpService.class);

        /* rx处理 */
        //观察者
        ProgressSubscriber subscriber = new ProgressSubscriber(baseApi);
        Observable observable = baseApi.getObservable(httpService);
                /*生命周期管理*/
        observable
                /*http请求线程*/
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                /*回调线程*/
                .observeOn(AndroidSchedulers.mainThread())
                /*结果判断*/
                .map(baseApi);
        /* 绑定 */
        observable.subscribe(subscriber);
    }
}
