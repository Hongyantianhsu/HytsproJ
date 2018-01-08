package com.bsz;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioGroup;

import com.bsz.fragment.BaseFragment;
import com.bsz.fragment.FindFragment;
import com.bsz.fragment.HomeFragment;
import com.bsz.fragment.MeFragment;
import com.bsz.fragment.NewsFragment;
import com.bsz.holder.MenuHolder;
import com.bsz.util.ColorUtils;
import com.bsz.util.UIUtils;

/**
 * 主界面Activity
 */
public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener{
    private Toolbar mtoolbar;
    private RadioGroup mradioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar = bind(R.id.toolbar);
        mradioGroup = bind(R.id.main_radio);

        mtoolbar.setTitle("卜算子");
        setSupportActionBar(mtoolbar);
        mtoolbar.inflateMenu(R.menu.menu_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerLayout mDrawerLayout = bind(R.id.drawer);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mtoolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        //侧滑菜单栏
        FrameLayout menuView = bind(R.id.drawer_view);
        MenuHolder menuHolder = new MenuHolder();
        menuView.addView(menuHolder.getRootView());

        mradioGroup.setOnCheckedChangeListener(this);
        mradioGroup.check(R.id.rb_home);

    }

    private void initVariable(){}

    /**
     * 获取相应的fragment
     * @param id fragment标志
     * @return
     */
    public Fragment getFragment(String id){
        return getSupportFragmentManager().findFragmentByTag(id);
    }

    private BaseFragment fragment;
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.rb_home:
                fragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fr_content,fragment,"HOME").commit();
                fragment.show();
                break;
            case R.id.rb_find:
                fragment = new FindFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fr_content,fragment,"FIND").commit();
                break;
            case R.id.rb_news:
//                List<SaveInfo> daoinfo = DBUtil.getInstance().queryDownAll();
//                L.e("kkk" + daoinfo.size()+"  "+daoinfo.get(0).getSavePath());
                fragment = new NewsFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fr_content,fragment,"NEWS").commit();
                break;
            case R.id.rb_me:
                fragment = new MeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fr_content,fragment,"ME").commit();
                break;
        }
    }

    /**
     * 取图片颜色来更改界面颜色
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

                mtoolbar.setBackgroundColor(vibrant.getRgb());
                if (android.os.Build.VERSION.SDK_INT >= 21) {
                    Window window = getWindow();
                    // 很明显，这两货是新API才有的。
                    window.setStatusBarColor(ColorUtils.colorBurn(vibrant.getRgb()));
                    window.setNavigationBarColor(ColorUtils.colorBurn(vibrant.getRgb()));
                }
            }
        });
    }

}
