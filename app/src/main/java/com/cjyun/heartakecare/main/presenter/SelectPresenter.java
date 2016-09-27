package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.base.listener.OnLoadDataListener;
import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.bean.UploadDeviceTypeBean;
import com.cjyun.heartakecare.main.model.SelectModel;
import com.cjyun.heartakecare.main.ui.SelectActivity;
import com.cjyun.heartakecare.main.view.SelectView;
import com.socks.library.KLog;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/7/18 0018
 * 描 述：TODO
 */
public class SelectPresenter extends BasePresenter<SelectView> {

    @Inject
    SelectModel mModel;

    @Inject
    SelectActivity mActivity;

    @Inject
    public SelectPresenter() {
    }

    /**
     * 上传设备类型
     */
    public void mUploadDeviceType() {
        mModel.UploadDeviceType(App.getContext(), new OnLoadDataListener<UploadDeviceTypeBean>() {
            @Override
            public void onSuccess(UploadDeviceTypeBean data) {
                String status = data.getStatus();
                KLog.e("上传设备类型：" + status);

            }

            @Override
            public void onFailed(String errorMsg) {
                KLog.e(errorMsg);
            }
        });
    }


}
