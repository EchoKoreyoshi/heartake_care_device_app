package com.cjyun.heartakecare.main.model;

import android.content.Context;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.base.listener.OnLoadDataListener;
import com.cjyun.heartakecare.bean.HomeUploadDataBean;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;
import com.socks.library.KLog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 创建者: vee
 * 时 间: 2016/7/27 0027
 * 描 述：TODO
 */
public class CheckedModel {
    @Inject
    public CheckedModel() {
    }

    /**
     * 上传检测数据
     */
    public void uploadTestData(Context context, OnLoadDataListener listener) {
        Observable<HomeUploadDataBean> observable = mUploadTestData(context);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeUploadDataBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailed(e.toString());
                    }

                    @Override
                    public void onNext(HomeUploadDataBean homeUploadDataBean) {
                        listener.onSuccess(homeUploadDataBean);
                        String status = homeUploadDataBean.getStatus();
                        KLog.e("上传检测数据：" + status);
                    }
                });
    }

    private Observable<HomeUploadDataBean> mUploadTestData(Context context) {
        List<String> datas = new ArrayList<>();
        String ACCESS_TOKEN = SharedPreferencesUtils.getString(context, "access_token", "");
        String TOKEN = "Bearer " + ACCESS_TOKEN;
        String SERIAL_NUMBER = SharedPreferencesUtils.getString(context, "device_id", "");
        String s1 = "{\"name\":\"wanger\",\"qrcode_serial_number\":\"10001011\",\"result\":\"3ng/ml\",\"disease\":\"心梗\",\"interpretation\":\"阴性\",\"t1\":\"T1\",\"t2\":\"T2\",\"c1\":\"C1\",\"test_time\":\"2016-09-27 02:47:57\"}";
        String s2 = "{\"name\":\"lisi\",\"qrcode_serial_number\":\"10001012\",\"result\":\"1\",\"disease\":\"心梗\",\"interpretation\":\"阳性\",\"t1\":\"T1\",\"t2\":\"T2\",\"c1\":\"C1\",\"test_time\":\"2016-09-27 02:49:57\"}";
        String s3 = "{\"name\":\"zhaoliu\",\"qrcode_serial_number\":\"10001013\",\"result\":\"4\",\"disease\":\"心梗\",\"interpretation\":\"阴性\",\"t1\":\"T1\",\"t2\":\"T2\",\"c1\":\"C1\",\"test_time\":\"2016-09-27 02:55:57\"}";
        datas.add(s1);
        datas.add(s2);
        datas.add(s3);
        
//        String DATAS="[{\"name\":\"wanger\",\"qrcode_serial_number\":\"10001011\",\"result\":\"3\",\"disease\":\"心梗\",\"interpretation\":\"阴性\",\"t1\":\"T1\",\"t2\":\"T2\",\"c1\":\"C1\",\"test_time\":\"2016-09-27 02:47:57\"},{\"name\":\"lisi\",\"qrcode_serial_number\":\"10001012\",\"result\":\"1\",\"disease\":\"心梗\",\"interpretation\":\"阳性\",\"t1\":\"T1\",\"t2\":\"T2\",\"c1\":\"C1\",\"test_time\":\"2016-09-27 02:49:57\"},{\"name\":\"zhaoliu\",\"qrcode_serial_number\":\"10001013\",\"result\":\"4\",\"disease\":\"心梗\",\"interpretation\":\"阴性\",\"t1\":\"T1\",\"t2\":\"T2\",\"c1\":\"C1\",\"test_time\":\"2016-09-27 02:55:57\"}]";
        KLog.e("datas数据为：" + datas);
        return App.getApp(context).getAppComponent().getApiServer().homeUploadData(TOKEN, SERIAL_NUMBER, datas);
    }


    /**
     * 获取系统的时间
     */
    private String getSystemDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String str = dateFormat.format(curDate);
        return str;
    }
}
