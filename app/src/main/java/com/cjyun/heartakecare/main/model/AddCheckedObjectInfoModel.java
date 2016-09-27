package com.cjyun.heartakecare.main.model;

import android.content.Context;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.base.listener.OnLoadDataListener;
import com.cjyun.heartakecare.bean.HomeUploadObjBean;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 创建者: vee
 * 时 间: 2016/9/26 0026
 * 描 述： TODO
 */
public class AddCheckedObjectInfoModel {
    @Inject
    public AddCheckedObjectInfoModel() {
    }

    /**
     * 上传检测对象
     */
    public void homeUploadCheckedObject(Context context, OnLoadDataListener listener) {
        Observable<HomeUploadObjBean> observable = mHomeUploadCheckedObject(context);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeUploadObjBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailed(e.toString());
                    }

                    @Override
                    public void onNext(HomeUploadObjBean homeUploadObjBean) {
                        listener.onSuccess(homeUploadObjBean);
                    }
                });
    }

    private Observable<HomeUploadObjBean> mHomeUploadCheckedObject(Context context) {
        String ACCESS_TOKEN = SharedPreferencesUtils.getString(context, "access_token", "");
        String TOKEN = "Bearer " + ACCESS_TOKEN;
        String SERIAL_NUMBER = SharedPreferencesUtils.getString(context, "device_id", "");
        String l = String.valueOf(System.currentTimeMillis());
        String NAME = "李四" + l;
        String AGE = "1994-10-02";
        Integer SEX = 0;
        String WEIGHT = "60Kg";
        String MEDICAL_TECO = "MDZZ" + l;
        return App.getApp(context).getAppComponent().getApiServer().homeUploadObject(TOKEN, SERIAL_NUMBER, NAME, AGE, SEX, WEIGHT, MEDICAL_TECO);
    }
}
