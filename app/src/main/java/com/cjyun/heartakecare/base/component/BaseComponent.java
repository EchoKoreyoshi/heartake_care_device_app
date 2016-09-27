package com.cjyun.heartakecare.base.component;

import com.cjyun.heartakecare.base.view.MVPView;

/**
 * 创建者: vee
 * 时 间: 2016/7/14 0014
 * 描 述： 组件的基本方法
 */
public interface BaseComponent<V extends MVPView> {
    //用于注入v层，实例化注入对象
    void inject(V view);
}
