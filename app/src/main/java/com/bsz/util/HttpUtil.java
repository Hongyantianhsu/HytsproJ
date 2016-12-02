package com.bsz.util;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 网络请求工具类
 * Created by sunyan on 16/11/30.
 */
public class HttpUtil {
    public static final String HOST = "http://app.novatarot.com/index.php/Api";
    public static void retrofitPost(String HOST,String url){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                        //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                        //增加返回值为Oservable<T>的支持
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RequestPostService service = retrofit.create(RequestPostService.class);
        Call<String> call = service.getString("955688503", "111");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

    public static void retrofitGet(String url){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                        //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                        //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                        //增加返回值为Oservable<T>的支持
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        RequestGetService service1 = retrofit.create(RequestGetService.class);
        Call<String> call = service1.getString("sunyan", "123456");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }


    public interface retrofitService{
    }
    public interface RequestPostService{
        @POST(HOST)
        Call<String> getString(@Query("uid") String uid,@Query("token") String token);
    }

    public interface RequestGetService{
        @GET("{name},{pwd}")
        Call<String> getString(@Path("name") String name, @Path("pwd") String pwd);
    }

    public interface RequestUploadService{

    }
}
