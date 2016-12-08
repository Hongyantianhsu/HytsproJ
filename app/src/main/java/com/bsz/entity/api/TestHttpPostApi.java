package com.bsz.entity.api;

import com.bsz.rx_retrofit.api.BaseApi;
import com.bsz.rx_retrofit.http.HttpService;
import com.bsz.rx_retrofit.listener.HttpOnNextListener;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import rx.Observable;

/**
 * 测试 获取账户余额api模型
 * Created by sunyan on 16/12/7.
 */
public class TestHttpPostApi extends BaseApi {
    private String uid;
    private String token;
    public TestHttpPostApi(HttpOnNextListener listener, RxAppCompatActivity rxAppCompatActivity) {
        super(listener, rxAppCompatActivity);
        setShowProgress(true);
        setCache(true);
        setCancel(true);
        setCookieNetWorkTime(60);
        setCookieNoNetWorkTime(60 * 60 * 24);
        setMothed("Personal/getBalance");
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Observable getObservable(HttpService methods) {
        return methods.getBalance(getUid(),getToken());
    }
}
