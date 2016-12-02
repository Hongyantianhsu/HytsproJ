package com.bsz.fragment;

import android.view.View;

import com.bsz.R;
import com.bsz.page.LoadingPage;
import com.bsz.util.UIUtils;

/**
 * 星盘咨询fragment
 * Created by sunyan on 16/11/25.
 */
public class AstrolabeFragment extends BaseFragment {

    @Override
    public View createLoadedView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.loading_page_error,null);
        return view;
    }

    @Override
    public LoadingPage.LoadResult load() {
        return LoadingPage.LoadResult.SUCCEED;
    }
}
