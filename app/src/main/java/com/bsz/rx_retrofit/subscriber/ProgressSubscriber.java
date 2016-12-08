package com.bsz.rx_retrofit.subscriber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.bsz.dao.CookieInfo;
import com.bsz.exception.HttpTimeException;
import com.bsz.rx_retrofit.api.BaseApi;
import com.bsz.rx_retrofit.http.dbutil.CookieDbUtil;
import com.bsz.rx_retrofit.listener.HttpOnNextListener;
import com.bsz.util.AppUtil;
import com.bsz.util.UIUtils;

import java.lang.ref.SoftReference;

import rx.Observable;
import rx.Subscriber;

/**
 * 观察者subsercribe
 * 订阅事件开始时显示progressdialog，事件失败或结束时进度条消失
 * Created by sunyan on 16/12/7.
 */
public class ProgressSubscriber<T> extends Subscriber<T> {
    //是否显示加载弹框
    private boolean isShowProgress;
    //回调listener集合
    private SoftReference<HttpOnNextListener> mhttpOnNextListeners;
    //RxAppcompatActivity集合
    private SoftReference<Context> mActivitys;
    //加载弹框
    private ProgressDialog pd;

    private BaseApi baseApi;

    public ProgressSubscriber(BaseApi baseApi){
        this.baseApi = baseApi;
        this.mhttpOnNextListeners = baseApi.getListener();
        this.mActivitys= new SoftReference<Context>(baseApi.getRxAppCompatActivity());
        if (isShowProgress){
            initProgressDialog(baseApi.isCancel());
        }
        setShowPorgress(baseApi.isShowProgress());
    }
    @Override
    public void onStart() {
        showProgressDialog();
        //缓存数据
        if (baseApi.isCache() && AppUtil.isNetworkAvailable(UIUtils.getContext())){//设置了是否缓存并且有网
            CookieInfo cookieInfo = CookieDbUtil.getInstance().queryCookieBy(baseApi.getUrl());
            if (cookieInfo != null){
                long time = (System.currentTimeMillis()-cookieInfo.getTime())/1000;
                if (time < baseApi.getCookieNetWorkTime()){//如果在设置的缓存时间内则回调
                    if (mhttpOnNextListeners.get() != null){
                        mhttpOnNextListeners.get().onCacheNext(cookieInfo.getResult());
                    }
                    onCompleted();
                    unsubscribe();
                }
            }
        }

    }

    @Override
    public void onCompleted() {
        dismissProgressDialog();
    }

    @Override
    public void onError(Throwable e) {
        dismissProgressDialog();
        if (baseApi.isCache()){
            Observable.just(baseApi.getUrl()).subscribe(new Subscriber<String>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onNext(String s) {
                    CookieInfo cookieInfo = CookieDbUtil.getInstance().queryCookieBy(s);
                    if (cookieInfo == null){
                        if (mhttpOnNextListeners.get() != null){
                            //访问错误回调
                            mhttpOnNextListeners.get().onError(new HttpTimeException("40040"));
                        }
                    }
                    long time = (System.currentTimeMillis() - cookieInfo.getTime())/1000;
                    if (time < baseApi.getCookieNetWorkTime()){//在缓存时间内
                        if (mhttpOnNextListeners.get() != null){
                            mhttpOnNextListeners.get().onCacheNext(cookieInfo.getResult());
                        }
                    }else{
                        CookieDbUtil.getInstance().deleteCookie(cookieInfo);
                        if (mhttpOnNextListeners.get() != null){
                            mhttpOnNextListeners.get().onError(new HttpTimeException("40040"));
                        }
                    }
                }
            });
        }else{
            if (mhttpOnNextListeners != null){
                mhttpOnNextListeners.get().onError(new HttpTimeException("40040"));
            }
        }
    }

    @Override
    public void onNext(T t) {
        if (mhttpOnNextListeners.get() != null){
            mhttpOnNextListeners.get().onNext(t);
        }
    }


    public boolean isShowPorgress() {
        return isShowProgress;
    }

    /**
     * 是否需要弹框设置
     * @param showPorgress
     */
    public void setShowPorgress(boolean showPorgress) {
        this.isShowProgress = showPorgress;
    }

    /**
     * 隐藏
     */
    private void dismissProgressDialog() {
        if(!isShowPorgress())return;
        if (pd != null && pd.isShowing()) {
            pd.dismiss();
        }
    }

    /**
     * 初始化加载框
     */
    private void initProgressDialog(boolean cancel) {
        Context context = mActivitys.get();
        if (pd == null && context != null) {
            pd = new ProgressDialog(context);
            pd.setCancelable(cancel);
            if (cancel) {
                pd.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        onCancelProgress();
                    }
                });
            }
        }
    }

    /**
     * 显示加载框
     */
    private void showProgressDialog() {
        if(!isShowPorgress())return;
        Context context = mActivitys.get();
        if (pd == null || context == null) return;
        if (!pd.isShowing()) {
            pd.show();
        }
    }

    /**
     * 取消ProgressDialog的时候，取消对observable的订阅，同时也取消了http请求
     */
    public void onCancelProgress() {
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }
    }
}
