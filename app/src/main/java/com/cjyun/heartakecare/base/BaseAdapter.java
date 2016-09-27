package com.cjyun.heartakecare.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.Collection;

/**
 * 创建者: vee
 * 时 间: 2016/7/30 0030
 * 描 述：适配器的基类
 */
public abstract class BaseAdapter<D extends Collection> extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder> {
    private OnItemClickListener mClickListener;
    private OnItemLongClickListener mLongClickListener;

    public D getData() {
        return mData;
    }

    private D mData;

    //添加点击事件
    public void setOnItemClickListener(OnItemClickListener listener) {
        mClickListener = listener;
    }

    //添加长按事件
    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mLongClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    public void setData(D data) {
        mData = data;
        notifyDataSetChanged();
    }

    public void clear(D data){
        mData.clear();
        notifyDataSetChanged();
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {
        public View mItemView;

        public BaseViewHolder(View itemView) {
            super(itemView);
            mItemView = itemView;
            if (mClickListener != null)
                itemView.setOnClickListener(v -> mClickListener.onItemClick(itemView, getPosition()));
            if (mLongClickListener != null)
                itemView.setOnLongClickListener(v -> mLongClickListener.OnItemLongClick(itemView, getPosition()));
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        boolean OnItemLongClick(View view, int position);
    }
}
