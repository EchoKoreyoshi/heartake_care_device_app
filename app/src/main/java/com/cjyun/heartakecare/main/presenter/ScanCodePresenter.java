package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.main.ui.ScanCodeActivity;
import com.cjyun.heartakecare.main.view.ScanCodeView;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/8/5 0005
 * 描 述： TODO
 */
public class ScanCodePresenter extends BasePresenter<ScanCodeView> {

    private ScanCodeActivity mActivity;

    @Inject
    public ScanCodePresenter(ScanCodeActivity activity) {
        mActivity = activity;
    }
}
