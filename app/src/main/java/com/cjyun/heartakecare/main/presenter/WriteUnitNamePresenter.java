package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.main.ui.WriteUnitNameActivity;
import com.cjyun.heartakecare.main.view.WriteUnitNameView;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/8/6 0006
 * 描 述： TODO
 */
public class WriteUnitNamePresenter extends BasePresenter<WriteUnitNameView> {

    private WriteUnitNameActivity mActivity;

    @Inject
    public WriteUnitNamePresenter(WriteUnitNameActivity activity) {
        mActivity = activity;
    }
}
