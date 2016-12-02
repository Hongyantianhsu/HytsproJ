package com.bsz.util;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * View工具类
 * Created by sunyan on 16/11/26.
 */
public class ViewUtils {

    /** 把自身从父View中移除 */
    public static void removeSelfFromParent(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != null && parent instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) parent;
                group.removeView(view);
            }
        }
    }
}
