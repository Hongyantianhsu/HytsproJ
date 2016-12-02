package com.bsz.holder;

import android.util.SparseArray;
import android.view.View;

/**
 * ViewHolder精简写法
 * Created by sunyan on 16/12/2.
 */
public class ViewHolder {
    public static <T>T get(View view, int id){
        SparseArray viewHolder = (SparseArray) view.getTag();
        if (viewHolder == null){
            viewHolder = new SparseArray();
            view.setTag(viewHolder);
        }
        View childView = (View) viewHolder.get(id);
        if (childView == null){
            childView = view.findViewById(id);
            viewHolder.put(id,childView);
        }
        return (T)childView;
    }
}
