package com.bsz.rx_retrofit.http;

import com.bsz.entity.HttpResult;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * retrfit网络请求接口定义
 * Created by sunyan on 16/12/7.
 */
public interface HttpService {
    /**
     * 获取账户余额
     * @param uid
     * @param token
     * @return
     */
    @FormUrlEncoded
    @POST("Personal/getBalance")
    Observable<HttpResult> getBalance(@Field("uid") String uid,@Field("token") String token);
}
