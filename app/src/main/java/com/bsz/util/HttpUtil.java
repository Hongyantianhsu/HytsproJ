package com.bsz.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 网络请求工具类RxJava+Retrofit
 * Created by sunyan on 16/11/30.
 */
public class HttpUtil {
    private static String url = "http://www.izaodao.com/Api/";
    private static HttpUtil httpUtil;
    private static Retrofit retrofit;
    private HttpUtil(){
        okhttp3.OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(5, TimeUnit.SECONDS);

        retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(url)
                .build();
    }

    public synchronized static HttpUtil getInstance(){
        if (httpUtil == null){
            httpUtil = new HttpUtil();
        }
        return httpUtil;
    }

    private Retrofit getRetrofit(){
        return retrofit;
    }

    /**
     * post请求例子
     */
    public void getB(){
        HttpService httpService = retrofit.create(HttpService.class);
//        Observable<String> observable = httpService.getBalance("144227242", "c7cdf4b757e24b2b14ea1ace6049d325");
        Observable<String> observable = httpService.getBalance(true);
        observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onStart() {
                        super.onStart();
                        //可以设置进度条开始显示
                        L.e("start");
                    }

                    @Override
                    public void onCompleted() {
                        //可以设置进度条消失
                        L.e("completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        L.e("errro" + e);
                    }

                    @Override
                    public void onNext(String s) {
                        //主线程
                        L.e("onnext：" + s);
                    }
                });
    }

    public interface HttpService{
        @POST("AppFiftyToneGraph/videoLink")
        Observable<String> getBalance(@Body boolean once_no);
    }
}
