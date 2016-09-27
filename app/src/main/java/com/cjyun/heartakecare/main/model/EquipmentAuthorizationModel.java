package com.cjyun.heartakecare.main.model;

import android.content.Context;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.base.listener.OnLoadDataListener;
import com.cjyun.heartakecare.bean.AuthenticationTokenBean;
import com.cjyun.heartakecare.bean.EquipmentAuthorizationV1Bean;
import com.cjyun.heartakecare.bean.EquipmentAuthorizationV2Bean;
import com.cjyun.heartakecare.bean.EquipmentAuthorizationV3Bean;
import com.cjyun.heartakecare.bean.RefreshTokenBean;
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
 * 时 间: 2016/9/21 0021
 * 描 述： TODO
 */
public class EquipmentAuthorizationModel {
    @Inject
    public EquipmentAuthorizationModel() {

    }

    /**
     * 设备授权第一步
     *
     * @param loadDataListener
     */
    public void AuthorizationkensV1(Context context, OnLoadDataListener loadDataListener) {

        Observable<EquipmentAuthorizationV1Bean> observable = AuthorizationkenV1(context);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EquipmentAuthorizationV1Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        loadDataListener.onFailed(e.toString());
                        KLog.e(e.toString() + "------------");
                    }

                    @Override
                    public void onNext(EquipmentAuthorizationV1Bean equipmentAuthorizationBean) {
                        loadDataListener.onSuccess(equipmentAuthorizationBean);
                        String Authorization = equipmentAuthorizationBean.getMessage();
                        KLog.e("成功返回：" + Authorization);
                    }
                });
    }


    public Observable<EquipmentAuthorizationV1Bean> AuthorizationkenV1(Context context) {
        String DEVICE_ID = SharedPreferencesUtils.getString(context, "device_id", "");
        return App.getApp(context).getAppComponent().getApiServer().getAuthorizationV1(
                Constant.Authorization.BASIC_VERIFY,
                Constant.Authorization.CLIENT_ID,
                Constant.Authorization.REDIRECT_URL,
                Constant.Authorization.RESPONSE_TYPE,
                Constant.Authorization.SCOPE,
                Constant.Authorization.DEVICE_NAME,
                DEVICE_ID);
    }

    /**
     * 第二步
     *
     * @param context
     * @param loadDataListener
     */
    public void AuthorizationkensV2(Context context, OnLoadDataListener loadDataListener) {

        Observable<EquipmentAuthorizationV2Bean> observable = AuthorizationkenV2(context);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EquipmentAuthorizationV2Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        loadDataListener.onFailed(e.toString());
                        KLog.e("错误信息：" + e.toString());
                    }

                    @Override
                    public void onNext(EquipmentAuthorizationV2Bean equipmentAuthorizationBean) {
                        loadDataListener.onSuccess(equipmentAuthorizationBean);
                        String code = equipmentAuthorizationBean.getCode();
                        SharedPreferencesUtils.setString(App.getContext(), "code", code);
                        KLog.e("成功返回:" + code);
                    }
                });
    }

    public Observable<EquipmentAuthorizationV2Bean> AuthorizationkenV2(Context context) {
        String DEVICE_ID = SharedPreferencesUtils.getString(context, "device_id", "");
        KLog.e("设备序列号:" + DEVICE_ID);
        return App.getApp(context).getAppComponent().getApiServer().getAuthorizationV2(
                Constant.Authorization.BASIC_VERIFY,
                Constant.Authorization.CLIENT_ID,
                Constant.Authorization.REDIRECT_URL,
                Constant.Authorization.RESPONSE_TYPE,
                Constant.Authorization.SCOPE,
                Constant.Authorization.DEVICE_NAME,
                DEVICE_ID);
    }


    /**
     * 第三步
     *
     * @param context
     * @param loadDataListener
     */
    public void AuthorizationkensV3(Context context, OnLoadDataListener loadDataListener) {

        Observable<EquipmentAuthorizationV3Bean> observable = AuthorizationkenV3(context);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<EquipmentAuthorizationV3Bean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        loadDataListener.onFailed(e.toString());
                        KLog.e("错误信息：" + e.toString());
                    }

                    @Override
                    public void onNext(EquipmentAuthorizationV3Bean equipmentAuthorizationBean) {
                        loadDataListener.onSuccess(equipmentAuthorizationBean);
                        String access_token = equipmentAuthorizationBean.getAccess_token();
                        String refresh_token = equipmentAuthorizationBean.getRefresh_token();
                        //存储sp
                        SharedPreferencesUtils.setString(App.getContext(), "access_token", access_token);
                        SharedPreferencesUtils.setString(App.getContext(), "refresh_token", refresh_token);
                        KLog.e("access_token:" + access_token + "   refresh_token:" + refresh_token);
                    }
                });
    }


    public Observable<EquipmentAuthorizationV3Bean> AuthorizationkenV3(Context context) {
        String CODE = SharedPreferencesUtils.getString(context, "code", "");
        KLog.e("code：" + CODE);
        return App.getApp(context).getAppComponent().getApiServer().getAuthorizationV3(
                Constant.Authorization.BASIC_VERIFY,
                Constant.Authorization.GRANT_TYPE,
                CODE,
                Constant.Authorization.CLIENT_ID,
                Constant.Authorization.SCOPES,
                Constant.Authorization.REDIRECT_URL
        );
    }

    /**
     * 验证token
     *
     * @param context
     * @param listener
     */
    public void authenticationToken(Context context, OnLoadDataListener listener) {
        Observable<AuthenticationTokenBean> observable = mAuthenticationToken(context);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AuthenticationTokenBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        KLog.e(e.toString());
                    }

                    @Override
                    public void onNext(AuthenticationTokenBean authenticationTokenBean) {
                        String status = authenticationTokenBean.getStatus();
                        KLog.e("status:" + status);
                    }
                });
    }


    private Observable<AuthenticationTokenBean> mAuthenticationToken(Context context) {
        String ACCESS_TOKEN = SharedPreferencesUtils.getString(App.getContext(), "access_token", "");
        String TOKEN = "Bearer " + ACCESS_TOKEN;
        return App.getApp(context).getAppComponent().getApiServer().AuthenticationToken(TOKEN);
    }

    /**
     * 刷新token
     *
     * @param context
     * @param loadDataListener
     */
    public void refreshedToken(Context context, OnLoadDataListener loadDataListener) {
        Observable<RefreshTokenBean> observable = mRefreshToken(context);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RefreshTokenBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        loadDataListener.onFailed(e.toString());
                    }

                    @Override
                    public void onNext(RefreshTokenBean getTokenBean) {
                        loadDataListener.onSuccess(getTokenBean);
                        String access_token = getTokenBean.getAccess_token();
                        SharedPreferencesUtils.setString(context, "access_token", access_token);
                        KLog.e("access_token:" + access_token);
                    }
                });

    }


    public Observable<RefreshTokenBean> mRefreshToken(Context context) {
        String REFRESH_TOKEN = SharedPreferencesUtils.getString(context, "refresh_token", "");
        KLog.e("refresh_token:" + REFRESH_TOKEN);
        return App.getApp(context).getAppComponent().getApiServer().refreshToken(
                Constant.Authorization.BASIC_VERIFY,
                Constant.RefreshToken.GRANT_TYPE,
                REFRESH_TOKEN
        );
    }
}
