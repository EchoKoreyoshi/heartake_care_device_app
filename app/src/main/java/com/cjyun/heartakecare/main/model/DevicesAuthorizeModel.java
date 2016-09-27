package com.cjyun.heartakecare.main.model;

import android.content.Context;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.base.listener.OnLoadDataListener;
import com.cjyun.heartakecare.bean.HomeAuthenticationBean;
import com.cjyun.heartakecare.bean.HomeAuthorizeToAppBean;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;
import com.socks.library.KLog;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 创建者: vee
 * 时 间: 2016/9/23 0023
 * 描 述： TODO
 */
public class DevicesAuthorizeModel {

    @Inject
    public DevicesAuthorizeModel() {
    }

    /**
     * 家庭版授权
     *
     * @param context
     * @param listener
     */
    public void homeAuthentication(Context context, OnLoadDataListener listener) {
        Observable<HomeAuthenticationBean> observable = mHomeAuthentication(context);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeAuthenticationBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailed(e.toString());
                    }

                    @Override
                    public void onNext(HomeAuthenticationBean homeAuthenticationBean) {
                        listener.onSuccess(homeAuthenticationBean);
                        List<HomeAuthenticationBean.AuthListBean> auth_list = homeAuthenticationBean.getAuth_list();
                        List<HomeAuthenticationBean.UserListBean> user_list = homeAuthenticationBean.getUser_list();
                        if (auth_list.size() == 0) {
                            KLog.e("----空状态----已成功执行-------");
                        } else {
                            int user_id = auth_list.get(0).getUser_id();
                            String phone_number = user_list.get(0).getPhone_number();
                            SharedPreferencesUtils.setInteger(context, "user_id", user_id);
                            KLog.e("user_id:" + user_id + "  phone_number:" + phone_number);
                        }
                    }
                });
    }

    private Observable<HomeAuthenticationBean> mHomeAuthentication(Context context) {
        String ACCESS_TOKEN = SharedPreferencesUtils.getString(context, "access_token", "");
        String TOKEN = "Bearer " + ACCESS_TOKEN;
        KLog.e("token:" + TOKEN);
        String SERIAL_NUMBER = SharedPreferencesUtils.getString(context, "device_id", "");
        KLog.e("serial_number:" + SERIAL_NUMBER);
        return App.getApp(context).getAppComponent().getApiServer().homeAuthentication(TOKEN, SERIAL_NUMBER);
    }

    /**
     * 家庭版授权给App
     */
    public void homeAuthorizeToApp(Context context, OnLoadDataListener listener) {
        Observable<HomeAuthorizeToAppBean> observable = mHomeAuthorizeToApp(context);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeAuthorizeToAppBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        listener.onFailed(e.toString());
                    }

                    @Override
                    public void onNext(HomeAuthorizeToAppBean homeAuthorizeToAppBean) {
                        listener.onSuccess(homeAuthorizeToAppBean);
                    }
                });
    }

    private Observable<HomeAuthorizeToAppBean> mHomeAuthorizeToApp(Context context) {
        String ACCESS_TOKEN = SharedPreferencesUtils.getString(context, "access_token", "");
        String TOKEN = "Bearer " + ACCESS_TOKEN;
        String SERIAL_NUMBER = SharedPreferencesUtils.getString(context, "device_id", "");
        int USER_ID = SharedPreferencesUtils.getInteger(context, "user_id", 1);
        return App.getApp(context).getAppComponent().getApiServer().homeAuthorizeToApp(TOKEN, SERIAL_NUMBER, USER_ID);
    }
}
