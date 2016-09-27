package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.bean.ProjectInfoBean;
import com.cjyun.heartakecare.main.ui.ProjectInfoActivity;
import com.cjyun.heartakecare.main.view.ProjectInfoView;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/8/4 0004
 * 描 述： TODO
 */
public class ProjectInfoPresenter extends BasePresenter<ProjectInfoView> {

    private ProjectInfoActivity mActivity;

    @Inject
    public ProjectInfoPresenter(ProjectInfoActivity activity) {
        mActivity = activity;
    }

    public void loadData() {

        ProjectInfoBean bean = new ProjectInfoBean();
        bean.projectName = "心肌肌钙蛋白";
        bean.count = 10;
        bean.productionNumber = "20160804";
        bean.term = "12";
        bean.vender = "xxxxxxxxxx";

        mActivity.setData(bean);
    }
}
