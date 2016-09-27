package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.main.ui.SettingsActivity;
import com.cjyun.heartakecare.main.view.SettingsView;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/8/6 0006
 * 描 述： TODO
 */
public class SettingsPresenter extends BasePresenter<SettingsView> {

    private SettingsActivity mActivity;

    @Inject
    public SettingsPresenter(SettingsActivity activity) {
        mActivity = activity;
    }
}
