package com.cjyun.heartakecare.base.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

/**
 * 创建者: vee
 * 时 间: 2016/8/1 0001
 * 描 述：弹窗的基本设置
 */
public abstract class BaseWindow<T> extends PopupWindow {

    private Context mContext;
    private T mData;
    private View mRootView;

    public BaseWindow(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public BaseWindow(Context context, T data) {
        super(context);
        mContext = context;
        mData = data;
        init();
    }

    public View getRootView() {
        return mRootView;
    }

    private void init() {
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mRootView = View.inflate(mContext, getContentLayoutId(), null);
        setContentView(mRootView);
        initView();
    }

    protected abstract int getContentLayoutId();

    public T getData() {
        return mData;
    }

    public Context getContext() {
        return mContext;
    }

    protected abstract void initView();

}
