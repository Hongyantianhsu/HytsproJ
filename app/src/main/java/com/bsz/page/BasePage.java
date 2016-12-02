package com.bsz.page;

import android.content.Context;
import android.view.View;

/**
 * Created by sunyan on 16/11/28.
 */
public abstract class BasePage {

    private Context ct;
    public BasePage(Context ct) {
        this.ct = ct;
    }

    public View getRootView(){
        LoadingPage mLoadingPage = new LoadingPage(ct) {
            @Override
            public View createSucceedView() {
                return initView();
            }

            @Override
            public LoadResult loadData() {
                return initData();
            }
        };
        return mLoadingPage;
    }

    public abstract View initView();
    public abstract LoadingPage.LoadResult initData();
}
