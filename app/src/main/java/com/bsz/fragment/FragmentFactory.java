package com.bsz.fragment;

import android.util.SparseArray;

/**
 * Created by sunyan on 16/11/25.
 */
public class FragmentFactory {
    public static final int TAB_TAROT = 0;//塔罗咨询
    public static final int TAB_ASTROLABE = 1;//星盘咨询
    public static final int TAB_OTHERS = 2;//其他咨询

    private static SparseArray<BaseFragment> mFragments = new SparseArray<>();

    public static BaseFragment createFragment(int index){
        BaseFragment fragment =  mFragments.get(index);

        if (fragment == null){
            switch (index){
                case TAB_TAROT:
                    fragment = new TarotFragment();
                    break;
                case TAB_ASTROLABE:
                    fragment = new AstrolabeFragment();
                    break;
                case TAB_OTHERS:
                    fragment = new OthersFragment();
                    break;
            }
            mFragments.put(index,fragment);
        }
        return fragment;
    }


}
