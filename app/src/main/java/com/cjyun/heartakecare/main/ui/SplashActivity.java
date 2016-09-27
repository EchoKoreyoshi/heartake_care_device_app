package com.cjyun.heartakecare.main.ui;

import android.telephony.TelephonyManager;
import android.view.Window;
import android.view.WindowManager;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseActivity;
import com.cjyun.heartakecare.main.component.DaggerSplashComponent;
import com.cjyun.heartakecare.main.module.SplashModule;
import com.cjyun.heartakecare.main.presenter.SplashPresenter;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;
import com.socks.library.KLog;

/**
 * 创建者: vee
 * 时 间: 2016/7/14 0014
 * 描 述：启动界面
 */
public class SplashActivity extends BaseActivity<SplashPresenter> {

    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerSplashComponent.builder().appComponent(appComponent)
                .splashModule(new SplashModule(this)).build().inject(this);
    }

    @Override
    protected void initView() {
        //全屏显示，去掉title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

    }

    @Override
    protected void initData() {
        App.getApp(this).getAppComponent().getHandler()
                .postDelayed(() -> {
                    startActivity(EquipmentAuthorizationActivity.class);
                    finish();
                }, 2000);
        if (SharedPreferencesUtils.getString(App.getContext(), "device_id", "") == null || SharedPreferencesUtils.getString(App.getContext(), "device_id", "").isEmpty())
            getDeviceId();

        mPresenter.loadData();
    }

    private void getDeviceId() {
        TelephonyManager telephonyManager = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
        String deviceId = telephonyManager.getDeviceId();
//        int deviceId1 =Integer.valueOf(deviceId);
        SharedPreferencesUtils.setString(this, "device_id", deviceId);
//        SharedPreferencesUtils.setInteger(this, "device_id1", deviceId1);
        KLog.e("deviceId:" + deviceId);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }


}
