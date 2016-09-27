package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.base.listener.OnLoadDataListener;
import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.bean.BindReagentBean;
import com.cjyun.heartakecare.bean.ProjectBean;
import com.cjyun.heartakecare.bean.QrcodeReagentBean;
import com.cjyun.heartakecare.main.model.CheckedProjectModel;
import com.cjyun.heartakecare.main.ui.CheckedProjectActivity;
import com.cjyun.heartakecare.main.view.CheckedProjectView;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;
import com.google.gson.Gson;
import com.socks.library.KLog;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/8/4 0004
 * 描 述： TODO
 */
public class CheckedProjectPresenter extends BasePresenter<CheckedProjectView> {

    private CheckedProjectActivity mActivity;
    @Inject
    CheckedProjectModel mModel;

    @Inject
    public CheckedProjectPresenter(CheckedProjectActivity activity) {
        mActivity = activity;
    }

    public void loadData() {
        ArrayList<ProjectBean> list = new ArrayList<>();
        String QrcodeReagent = SharedPreferencesUtils.getString(mActivity, "qrcode_json", "");
        QrcodeReagentBean qrcodeReagentBean = new Gson().fromJson(QrcodeReagent, QrcodeReagentBean.class);
        String project_name = qrcodeReagentBean.getProject_name();
        int single_box_quantity = qrcodeReagentBean.getSingle_box_quantity();

        KLog.e("项目名：" + project_name + "  剩余次数：" + single_box_quantity);

        list.add(new ProjectBean(project_name, single_box_quantity));
        mActivity.loadList(list);

        mModel.bindReagent(App.getContext(), new OnLoadDataListener<BindReagentBean>() {
            @Override
            public void onSuccess(BindReagentBean data) {
                String status = data.getStatus();
                KLog.e("绑定试剂：" + status);
            }

            @Override
            public void onFailed(String errorMsg) {
                KLog.e(errorMsg);
            }
        });
    }

}
