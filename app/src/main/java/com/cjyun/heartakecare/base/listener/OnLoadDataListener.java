package com.cjyun.heartakecare.base.listener;

/**
 * 创建者: vee
 * 时 间: 2016/7/18 0018
 * 描 述： 数据加载回调
 */
public interface OnLoadDataListener<T> {
    void onSuccess(T data);
    void onFailed(String errorMsg);
}
