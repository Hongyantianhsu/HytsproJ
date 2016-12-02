package com.bsz.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.View;

import com.bsz.BaseApplication;

/**
 * Created by sunyan on 16/11/25.
 */
public class UIUtils {

    public static Context getContext() {
        return BaseApplication.getApplication();
    }

    /** 获取资源 */
    public static Resources getResources() {
        return getContext().getResources();
    }

    /** 获取文字数组 */
    public static String[] getStringArray(int resId) {
        return getResources().getStringArray(resId);
    }

    public static int getColor(int resId){
        return getResources().getColor(resId);
    }

    public static long getMainThreadId() {
        return BaseApplication.getMainThreadId();
    }

    /** 获取主线程的handler */
    public static Handler getHandler() {
        return BaseApplication.getMainThreadHandler();
    }


    /** 在主线程执行runnable */
    public static boolean post(Runnable runnable) {
        return getHandler().post(runnable);
    }

    //判断当前的线程是不是在主线程
    public static boolean isRunInMainThread() {
        return android.os.Process.myTid() == getMainThreadId();
    }

    public static void runInMainThread(Runnable runnable) {
        if (isRunInMainThread()) {
            runnable.run();
        } else {
            post(runnable);
        }
    }

    /**
     * findViewById 精简版
     * @param view 依附的布局
     * @param resId 控件id
     * @param <T>
     * @return
     */
    public static <T>T bind(View view , int resId){
        return (T)view.findViewById(resId);
    }
}
