package com.bsz.fragment;

import android.view.View;

import com.bsz.R;
import com.bsz.page.LoadingPage;
import com.bsz.util.UIUtils;

/**
 * 其他咨询fragment
 * Created by sunyan on 16/11/25.
 */
public class OthersFragment extends BaseFragment {

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
