package com.bsz.fragment;

import android.view.View;

import com.bsz.page.LoadingPage;

/**
 * Created by sunyan on 16/11/28.
 */
public class MeFragment extends BaseFragment {
    @Override
    public View createLoadedView() {
        return null;
    }

    @Override
    public LoadingPage.LoadResult load() {
        return LoadingPage.LoadResult.ERROR;
    }
}
