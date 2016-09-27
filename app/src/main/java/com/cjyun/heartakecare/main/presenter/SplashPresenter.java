package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.main.model.SplashModel;
import com.cjyun.heartakecare.main.view.SplashView;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/7/14 0014
 * 描 述：TODO
 */
public class SplashPresenter extends BasePresenter<SplashView> {

    @Inject
    SplashModel mModel;

    @Inject
    public SplashPresenter() {
    }

    public void loadData() {
    }
}
