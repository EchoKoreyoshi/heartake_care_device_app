package com.cjyun.heartakecare.main.model;

import android.content.Context;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.base.listener.OnLoadDataListener;
import com.cjyun.heartakecare.bean.BindReagentBean;
import com.cjyun.heartakecare.bean.QrcodeReagentBean;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;
import com.google.gson.Gson;
import com.socks.library.KLog;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 创建者: vee
 * 时 间: 2016/9/26 0026
 * 描 述： 检测项目的model
 */
public class CheckedProjectModel {
    @Inject
    public CheckedProjectModel() {
    }

    /**
     * 绑定试剂
     */
    public void bindReagent(Context context, OnLoadDataListener listener) {
        Observable<BindReagentBean> observable = mBindReagent(context);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BindReagentBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailed(e.toString());
                    }

                    @Override
                    public void onNext(BindReagentBean bindReagentBean) {
                        listener.onSuccess(bindReagentBean);
                    }
                });
    }

    private Observable<BindReagentBean> mBindReagent(Context context) {
        String ACCESS_TOKEN = SharedPreferencesUtils.getString(context, "access_token", "");
        String TOKEN = "Bearer " + ACCESS_TOKEN;
        String SERIAL_NUMBER = SharedPreferencesUtils.getString(context, "device_id", "");
        String QrcodeReagent = SharedPreferencesUtils.getString(context, "qrcode_json", "");
        QrcodeReagentBean qrcodeReagentBean = new Gson().fromJson(QrcodeReagent, QrcodeReagentBean.class);
        String QRCODE_SERIAL_NUMBER = qrcodeReagentBean.getSerial_number();
        KLog.e("试剂序列号：" + QRCODE_SERIAL_NUMBER);
        return App.getApp(context).getAppComponent().getApiServer().bindReagent(TOKEN, SERIAL_NUMBER, QRCODE_SERIAL_NUMBER);
    }
}
