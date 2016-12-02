package com.bsz.page;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.bsz.R;
import com.bsz.util.UIUtils;

/**
 * 加载显示界面
 * Created by sunyan on 16/11/26.
 */
public abstract class LoadingPage extends FrameLayout {
    private static final int STATE_ERROR = -1;//加载失败
    private static final int STATE_LOADING = 0;//加载中
    private static final int STATE_EMPTY = 1;//加载成功,但没数据
    private static final int STATE_SUCCEED = 2;//加载成功,有数据

    private View mErrorView;
    private View mLoadingView;
    private View mEmptyView;
    private View mSucceedView;

    private int mState ;//当前状态

    public LoadingPage(Context context) {
        super(context);
        init();
    }

    private void init() {
        setBackgroundColor(UIUtils.getColor(R.color.bg_page));
        mState = STATE_EMPTY;

        //创建对应的View，并添加到布局中
        mErrorView = createView(STATE_ERROR);
        if (mErrorView != null){
            addView(mErrorView,new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }

        mLoadingView = createView(STATE_LOADING);
        if (mLoadingView != null){
            addView(mLoadingView,new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }

        mEmptyView = createView(STATE_EMPTY);
        if (mEmptyView != null){
            addView(mEmptyView,new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
        showPageSafe();
    }

    private View createView(int viewType) {

        View view = null;
        switch (viewType) {
            case STATE_ERROR:
                view = View.inflate(UIUtils.getContext(),R.layout.loading_page_error,null);
                view.findViewById(R.id.page_bt).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        show();
                    }
                });
                break;
            case STATE_LOADING:
                view = View.inflate(UIUtils.getContext(),R.layout.loading_page_loading,null);
                break;
            case STATE_EMPTY:
                view = View.inflate(UIUtils.getContext(),R.layout.loading_page_empty,null);
                break;
            case STATE_SUCCEED:
                view = createSucceedView();
                break;
        }
        return view;
    }

    /**
     * 显示对应的view
     */
    private void showPage(){
        if (mErrorView != null){
            mErrorView.setVisibility(mState == STATE_ERROR ? View.VISIBLE : View.GONE);
        }

        if (mLoadingView != null){
            mLoadingView.setVisibility(mState == STATE_LOADING ? View.VISIBLE : View.GONE);
        }

        if (mEmptyView != null){
            mEmptyView.setVisibility(mState == STATE_EMPTY ? View.VISIBLE : View.GONE);
        }

        // 只有数据成功返回了，才知道成功的View该如何显示，因为该View的显示依赖加载完毕的数据
        if (mState == STATE_SUCCEED && mSucceedView == null) {
            mSucceedView = createSucceedView();
            addView(mSucceedView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        }

        if (null != mSucceedView) {
            mSucceedView.setVisibility(mState == STATE_SUCCEED ? View.VISIBLE : View.INVISIBLE);
        }

    }

    public synchronized void show(){
        if (mState == STATE_EMPTY){
            mState = STATE_LOADING;
            LoadingTask loadingTask = new LoadingTask();
            new Thread(loadingTask).start();
        }
        showPageSafe();
    }

    /**
     * 主线程中更新界面
     */
    private void showPageSafe(){
        UIUtils.runInMainThread(new Runnable() {
            @Override
            public void run() {
                showPage();
            }
        });
    }

    public abstract View createSucceedView();
    public abstract LoadResult loadData();

    /**
     * data下载线程
     */
    class LoadingTask implements Runnable {
        @Override
        public void run() {
            final LoadResult loadResult = loadData();
            UIUtils.runInMainThread(new Runnable() {//主线程改变UI
                @Override
                public void run() {
                    //状态的改变和界面息息相关，所以需要放到主线程来赋值，保障同步性
                    mState = loadResult.getValue();//根据枚举对象的返回值来改变显示状态码
                    showPage();
                }
            });
        }
    }

    public enum LoadResult{
        ERROR(-1),EMPTY(1),SUCCEED(2);
        int value;
        LoadResult(int value){
            this.value = value;
        }
        public int getValue(){
            return value;
        }
    }
}
