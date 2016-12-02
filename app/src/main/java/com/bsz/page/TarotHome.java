package com.bsz.page;

import android.content.Context;
import android.view.View;

import com.bsz.R;
import com.bsz.util.UIUtils;

/**
 * Created by sunyan on 16/11/28.
 */
public class TarotHome extends BasePage{

    public TarotHome(Context ct) {
        super(ct);
    }

    @Override
    public View initView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.loading_page_error,null);
        return view;
    }

    @Override
    public LoadingPage.LoadResult initData() {
        return LoadingPage.LoadResult.SUCCEED;
    }
}
