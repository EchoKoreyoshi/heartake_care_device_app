package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.main.ui.AboutUsActivity;
import com.cjyun.heartakecare.main.view.AboutUsView;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/8/8 0008
 * 描 述： TODO
 */
public class AboutUsPresenter extends BasePresenter<AboutUsView> {
    private AboutUsActivity mActivity;

    @Inject
    public AboutUsPresenter(AboutUsActivity activity) {
        mActivity = activity;
    }
}
