package com.bsz.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bsz.page.LoadingPage;
import com.bsz.util.UIUtils;
import com.bsz.util.ViewUtils;

import java.util.List;

/**
 * Fragment基类
 * Created by sunyan on 16/11/25.
 */
public abstract class BaseFragment extends Fragment {
    private LoadingPage mLoadingPage;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mLoadingPage == null){
            mLoadingPage = new LoadingPage(UIUtils.getContext()) {
                @Override
                public View createSucceedView() {
                    return createLoadedView();
                }

                @Override
                public LoadResult loadData() {
                    return load();
                }
            };
        } else {
            ViewUtils.removeSelfFromParent(mLoadingPage);
        }
        return mLoadingPage;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    public View getRootView(){
        if (mLoadingPage != null){
            return mLoadingPage;
        }
        return null;
    }
    /**
     * 显示界面
     */
    public void show(){
        if (mLoadingPage != null){
            mLoadingPage.show();
        }
    }

    public LoadingPage.LoadResult check(Object obj) {
        if (obj == null) {
            return LoadingPage.LoadResult.ERROR;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() == 0) {
                return LoadingPage.LoadResult.EMPTY;
            }
        }
        return LoadingPage.LoadResult.SUCCEED;
    }
    public abstract View createLoadedView();
    public abstract LoadingPage.LoadResult load();
}
