package com.cjyun.heartakecare.base.module;

import com.cjyun.heartakecare.base.view.MVPView;

/**
 * 创建者: vee
 * 时 间: 2016/7/13 0013
 * 描 述： TODO
 */
public class BaseModule<A extends MVPView> {
    private A mView;

    public BaseModule(A activity) {
        mView = activity;
    }

    public A getView() {
        return mView;
    }

}
