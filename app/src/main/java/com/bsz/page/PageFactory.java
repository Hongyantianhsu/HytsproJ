package com.bsz.page;

import android.content.Context;
import android.util.SparseArray;

/**
 * Created by sunyan on 16/11/28.
 */
public class PageFactory {
    public static final int TAB_TAROT = 0;//塔罗咨询
    public static final int TAB_ASTROLABE = 1;//星盘咨询
    public static final int TAB_OTHERS = 2;//其他咨询

    private static SparseArray<BasePage> mPages = new SparseArray<>();

    public static BasePage createPage(Context ct,int index){
        BasePage page =  mPages.get(index);

        if (page == null){
            switch (index){
                case TAB_TAROT:
                    page = new TarotHome(ct);
                    break;
                case TAB_ASTROLABE:
                    page = new AstrolabePage(ct);
                    break;
                case TAB_OTHERS:
                    page = new OtherPage(ct);
                    break;
            }
            mPages.put(index,page);
        }
        return page;
    }

}
