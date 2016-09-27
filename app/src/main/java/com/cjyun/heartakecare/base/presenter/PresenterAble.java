package com.cjyun.heartakecare.base.presenter;

import com.cjyun.heartakecare.base.view.MVPView;

/**
 * 创建者: vee
 * 时 间: 2016/7/13 0013
 * 描 述： TODO
 */
public interface PresenterAble<T extends MVPView> {
    void attach(T v);
    void detach();
}
