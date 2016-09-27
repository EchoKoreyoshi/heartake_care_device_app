package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.base.listener.OnLoadDataListener;
import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.bean.AddCheckedObjectInfoBean;
import com.cjyun.heartakecare.bean.HomeUploadObjBean;
import com.cjyun.heartakecare.main.model.AddCheckedObjectInfoModel;
import com.cjyun.heartakecare.main.ui.AddCheckedObjectInfoActivity;
import com.cjyun.heartakecare.main.view.AddCheckedObjectInfoView;
import com.cjyun.heartakecare.utils.ToastUtils;
import com.socks.library.KLog;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/8/5 0005
 * 描 述： TODO
 */
public class AddCheckedObjectInfoPresenter extends BasePresenter<AddCheckedObjectInfoView> {

    @Inject
    AddCheckedObjectInfoModel mModel;

    private AddCheckedObjectInfoActivity mActivity;

    @Inject
    public AddCheckedObjectInfoPresenter(AddCheckedObjectInfoActivity activity) {
        mActivity = activity;
    }

    public void loadData() {
        AddCheckedObjectInfoBean bean = new AddCheckedObjectInfoBean();
        bean.objectName = "张三";
        bean.objectAge = "1999-06";
        bean.objectSex = "男";
        bean.objectWeight = "60Kg";
        bean.objectHistroy = "MDZZ";
        mActivity.setData(bean);
    }

    /**
     * 上传检测对象
     */
    public void homeUploadCheckedObject() {
        mModel.homeUploadCheckedObject(App.getContext(), new OnLoadDataListener<HomeUploadObjBean>() {
            @Override
            public void onSuccess(HomeUploadObjBean data) {
                String status = data.getStatus();
                KLog.e("上传检测对象：" + status);
                ToastUtils.showMessage("上传检测对象：" + status);
            }

            @Override
            public void onFailed(String errorMsg) {
                KLog.e(errorMsg);
                ToastUtils.showMessage("上传失败：" + errorMsg);
            }
        });
    }

}
