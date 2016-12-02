package com.bsz.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Adapter基类
 * Created by sunyan on 16/12/2.
 */
public abstract class SimpleBaseAdapter<T> extends BaseAdapter {

    protected Context c = null;

    protected LayoutInflater layoutInflater = null;

    protected List<T> datas = null;

    public SimpleBaseAdapter(Context c , List<T> datas){
        this.c = c;
        this.datas = datas;
        layoutInflater = LayoutInflater.from(c);
    }

    /**
     * 刷新适配器数据源
     * @param datas
     */
    public void refreshDatas(List<T> datas){
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    /**
     * 添加数据列表项
     * @param newDatas
     */
    public void addNewDatas(List<T> newDatas){
        this.datas.add((T) newDatas);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas != null ? datas.size() : 0;
    }

    @Override
    public T getItem(int position) {
        return datas != null ? datas.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 逐一绘制每一条item
     * @param position 位置从0开始
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public abstract View getView(int position, View convertView, ViewGroup parent);

}