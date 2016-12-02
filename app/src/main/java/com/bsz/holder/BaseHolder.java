package com.bsz.holder;

import android.view.View;

/**
 * view结构体基类
 * Created by sunyan on 16/11/29.
 */
public abstract class BaseHolder<Data> {

    private Data mdata;

    public BaseHolder() {
        initView();
    }

    public View getRootView(){
        return initView();
    }

    public void setData(Data data){
        this.mdata = data;
        refreshView();
    }

    public Data getData(){
        return mdata;
    }

    /**
     * UI初始化
     * @return
     */
    public abstract View initView();

    /**
     * 刷新UI
     */
    public abstract void refreshView();
}
