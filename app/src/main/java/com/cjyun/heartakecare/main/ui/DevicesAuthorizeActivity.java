package com.cjyun.heartakecare.main.ui;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseActivity;
import com.cjyun.heartakecare.main.component.DaggerDevicesAuthorizeComponent;
import com.cjyun.heartakecare.main.module.DevicesAuthorizeModule;
import com.cjyun.heartakecare.main.presenter.DevicesAuthorizePresenter;
import com.cjyun.heartakecare.main.view.DevicesAuthorizeView;
import com.cjyun.heartakecare.utils.Constant;
import com.socks.library.KLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/8/6 0006
 * 描 述：设备授权
 */
public class DevicesAuthorizeActivity extends BaseActivity<DevicesAuthorizePresenter> implements DevicesAuthorizeView {
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.menu)
    ImageView mMenu;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.id)
    TextView mId;
    @BindView(R.id.iv_code)
    ImageView mIvCode;
    private boolean mTag = true;
    private long mThreadId;


    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerDevicesAuthorizeComponent.builder()
                .appComponent(appComponent)
                .devicesAuthorizeModule(new DevicesAuthorizeModule(this))
                .build().inject(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {
        setContentView(R.layout.activity_devices_authorize);
        ButterKnife.bind(this);

        mTitle.setText(getResources().getText(R.string.devices_authorize_title));
        mTitle.setTextColor(Color.BLACK);
        mMenu.setBackground(null);
    }

    @Override
    protected void initData() {
        //生成二维码
        mPresenter.createQRcode();
        new Thread(() -> {
            while (mTag) {
                mThreadId = Thread.currentThread().getId();
                mPresenter.homeUserAuthentication();
                KLog.e("当前线程的ID：" + mThreadId);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();


    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rl_come_back})
    public void onClick(View view) {
        mTag = false;
        finish();
    }

    public void showDialog(String s) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(getResources().getText(R.string.devices_authorize_dialog_title))
                .setMessage(Constant.DevicesAuthorize.DIALOG_MSG01 + s + Constant.DevicesAuthorize.DIALOG_MSG02)
                .setPositiveButton(getResources().getText(R.string.devices_authorize_dialog_positivebutton), (dialog, which) -> {
                    dialog.dismiss();
                })
                .setNegativeButton(getResources().getText(R.string.devices_authorize_dialog_negativebutton), (dialog, which) -> {
                    //同意-->授权给App
                    mPresenter.homeAuthorize2App();
                    dialog.dismiss();
                }).create();
        alertDialog.show();
    }

    public void setTag(boolean b) {
        mTag = b;
    }
}
