package com.bsz.holder;

import android.view.View;
import android.widget.RelativeLayout;

import com.bsz.R;
import com.bsz.bean.UserInfo;
import com.bsz.util.UIUtils;

/**
 * 侧滑菜单view
 * Created by sunyan on 16/11/29.
 */
public class MenuHolder extends BaseHolder<UserInfo> implements View.OnClickListener{
    @Override
    public View initView() {
        View view = View.inflate(UIUtils.getContext(), R.layout.menu_list,null);
        RelativeLayout rlhome = UIUtils.bind(view, R.id.home_layout);
        RelativeLayout rlsetting = UIUtils.bind(view,R.id.setting_layout);
        RelativeLayout rllivevideo = UIUtils.bind(view,R.id.livevideo_layout);

        rlhome.setOnClickListener(this);
        rlsetting.setOnClickListener(this);
        rllivevideo.setOnClickListener(this);
        return view;
    }

    @Override
    public void refreshView() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.home_layout:
                break;
            case R.id.setting_layout:
                break;
            case R.id.livevideo_layout://直播
                break;
        }
    }
}
