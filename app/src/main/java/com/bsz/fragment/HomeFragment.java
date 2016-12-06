package com.bsz.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.graphics.Palette;
import android.util.TypedValue;
import android.view.View;

import com.bsz.R;
import com.bsz.page.LoadingPage.LoadResult;
import com.bsz.util.ColorUtils;
import com.bsz.util.HttpUtil;
import com.bsz.util.UIUtils;
import com.bsz.widget.PagerSlidingTabStrip;

/**
 * 首页fragmnet
 * Created by sunyan on 16/11/26.
 */
public class HomeFragment extends BaseFragment{
    private View view;
    private PagerSlidingTabStrip mPagerSlidingTabStrip;
    private int CURRTENT_PAGE = 0;

    @Override
    public View createLoadedView() {
        view = View.inflate(UIUtils.getContext(), R.layout.fragment_home,null);
        HttpUtil.getInstance().getB();
        mPagerSlidingTabStrip = (PagerSlidingTabStrip) view.findViewById(R.id.tabs_home);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.pager_home);
        viewPager.setAdapter(new MyFragmentAdapter(getChildFragmentManager()));
        mPagerSlidingTabStrip.setViewPager(viewPager);
        mPagerSlidingTabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                colorChange(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        if (isAdded()){
            initTabsValue();
        }

        viewPager.setCurrentItem(CURRTENT_PAGE);
        return view;
    }

    private void setCurrentItem(int i){
        CURRTENT_PAGE = i;
    }

    /**
     * 数据加载
     * @return
     */
    @Override
    public LoadResult load() {
        return LoadResult.SUCCEED;
    }

    class MyFragmentAdapter extends FragmentPagerAdapter{

        private String[] TITLES;
        public MyFragmentAdapter(FragmentManager fm) {
            super(fm);
            TITLES = UIUtils.getStringArray(R.array.titles);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.createFragment(position);
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }
    }

    /**
     * mPagerSlidingTabStrip默认值配置
     *
     */
    private void initTabsValue() {
        // 底部游标颜色
        mPagerSlidingTabStrip.setIndicatorColor(Color.BLUE);
        // tab的分割线颜色
        mPagerSlidingTabStrip.setDividerColor(Color.TRANSPARENT);
        // tab背景
        mPagerSlidingTabStrip.setBackgroundColor(Color.parseColor("#4876FF"));
        // tab底线高度
        mPagerSlidingTabStrip.setUnderlineHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                1, getResources().getDisplayMetrics()));
        // 游标高度
        mPagerSlidingTabStrip.setIndicatorHeight((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                5, getResources().getDisplayMetrics()));
        // 选中的文字颜色
        mPagerSlidingTabStrip.setSelectedTextColor(Color.WHITE);
        // 正常文字颜色
        mPagerSlidingTabStrip.setTextColor(Color.BLACK);
    }


    /**
     * 界面颜色的更改
     */
    private void colorChange(int position) {
        int ResId[] = {R.mipmap.bg01,R.mipmap.bg02,R.mipmap.bg03};
        Bitmap bitmap = BitmapFactory.decodeResource(UIUtils.getResources(), ResId[position]);
        // Palette的部分
        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
            /**
             * 提取完之后的回调方法
             */
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch vibrant = palette.getVibrantSwatch();
				/* 界面颜色UI统一性处理,看起来更Material一些 */
                mPagerSlidingTabStrip.setBackgroundColor(vibrant.getRgb());
                mPagerSlidingTabStrip.setTextColor(vibrant.getTitleTextColor());
                // 其中状态栏、游标、底部导航栏的颜色需要加深一下，也可以不加，具体情况在代码之后说明
                mPagerSlidingTabStrip.setIndicatorColor(ColorUtils.colorBurn(vibrant.getRgb()));
            }
        });
    }
}
