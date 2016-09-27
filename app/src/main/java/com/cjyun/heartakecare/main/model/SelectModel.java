package com.cjyun.heartakecare.main.model;

import android.content.Context;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.base.listener.OnLoadDataListener;
import com.cjyun.heartakecare.bean.UploadDeviceTypeBean;
import com.cjyun.heartakecare.utils.Constant;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;
import com.socks.library.KLog;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 创建者: vee
 * 时 间: 2016/7/18 0018
 * 描 述：TODO
 */
public class SelectModel {
    @Inject
    public SelectModel() {
    }

    /**
     * 上传设备类型
     *
     * @param context
     * @param listener
     */
    public void UploadDeviceType(Context context, OnLoadDataListener listener) {
        Observable<UploadDeviceTypeBean> observable = mUploadDeviceType(context);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UploadDeviceTypeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailed(e.toString());
                        KLog.e(e);
                    }

                    @Override
                    public void onNext(UploadDeviceTypeBean uploadDeviceTypeBean) {
                        SharedPreferencesUtils.setInteger(context,"SelectActivityTag",1);
                        listener.onSuccess(uploadDeviceTypeBean);
                        String status = uploadDeviceTypeBean.getStatus();
                        KLog.e("上传设备类型：" + status);
                    }
                });
    }

    private Observable<UploadDeviceTypeBean> mUploadDeviceType(Context context) {
        String ACCESS_TOKEN = SharedPreferencesUtils.getString(context, "access_token", "");
        String TOKEN = "Bearer " + ACCESS_TOKEN;
        KLog.e("token:" + TOKEN);
        String SERIAL_NUMBER = SharedPreferencesUtils.getString(context, "device_id", "");
        KLog.e("上传设备类型的serial_number:" + SERIAL_NUMBER);

        return App.getApp(context).getAppComponent().getApiServer().UploadDeviceType(TOKEN, SERIAL_NUMBER, Constant.UploadDeviceType.HOME_USER);
    }


}
