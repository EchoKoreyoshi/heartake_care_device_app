package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.main.ui.GSMDataActivity;
import com.cjyun.heartakecare.main.view.GSMDataView;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/8/9 0009
 * 描 述： TODO
 */
public class GSMDataPersenter extends BasePresenter<GSMDataView> {

    private GSMDataActivity mActivity;

    @Inject
    public GSMDataPersenter(GSMDataActivity activity) {
        mActivity = activity;
    }
}
