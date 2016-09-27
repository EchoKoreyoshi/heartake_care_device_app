package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.bean.ResultDetailsBean;
import com.cjyun.heartakecare.main.ui.ResultDetailsActivity;
import com.cjyun.heartakecare.main.view.ResultDetailsView;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/8/6 0006
 * 描 述： TODO
 */
public class ResultDetailsPresenter extends BasePresenter<ResultDetailsView> {

    private ResultDetailsActivity mActivity;

    @Inject
    public ResultDetailsPresenter(ResultDetailsActivity activity) {
        mActivity = activity;
    }

    public void loadData() {
        ResultDetailsBean bean = new ResultDetailsBean();
        bean.checkedObjectName = "呵呵";
        bean.date = "2016-01-01";
        bean.checkedProjectName = "心肌肌钙蛋白l (cTnl)";
        bean.resultReference = "<0.5ng/ml";
        bean.checkedResult = "0.3ng/ml";
        bean.objectDisease = "心梗";
        bean.objectClinical = "阴性";
        mActivity.setData(bean);
    }
}

