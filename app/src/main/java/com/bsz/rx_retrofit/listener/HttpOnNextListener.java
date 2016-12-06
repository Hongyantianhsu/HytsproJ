package com.bsz.rx_retrofit.listener;

/**
 * 成功回调处理
 * Created by sunyan on 16/12/5.
 */
public interface HttpOnNextListener<T> {
    /**
     * 成功后回调方法
     * @param t
     */
    public abstract void onNext(T t);

    /**
     * 緩存回調結果
     * @param string
     */
    public abstract void onCacheNext(String string);

    /**
     * 失败或者错误方法
     * 主动调用，更加灵活
     * @param e
     */
    public abstract void onError(Throwable e);

    /**
     * 取消回調
     */
    public abstract void onCancel();
}
