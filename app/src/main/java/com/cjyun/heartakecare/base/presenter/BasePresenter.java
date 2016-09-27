package com.cjyun.heartakecare.base.presenter;

import com.cjyun.heartakecare.base.view.MVPView;

/**
 * 创建者: vee
 * 时 间: 2016/7/14 0014
 * 描 述： P层基类
 */
public class BasePresenter<V extends MVPView> implements PresenterAble<V> {

    private V mV;

    @Override
    public void attach(V v) {
        mV = v;
    }

    @Override
    public void detach() {
    }

    public V getView(){
        return mV;
    }

    //判断界面是否绑定
    public boolean isViewAttached() {
        return mV != null;
    }
}
