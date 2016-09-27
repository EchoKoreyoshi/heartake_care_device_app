package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.main.ui.WLANSettingsActivity;
import com.cjyun.heartakecare.main.view.WLANSettingsView;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/8/11 0011
 * 描 述： TODO
 */
public class WLANSettingsPresenter extends BasePresenter<WLANSettingsView> {

    private WLANSettingsActivity mActivity;

    @Inject
    public WLANSettingsPresenter(WLANSettingsActivity activity) {
        mActivity = activity;
    }

}
