package com.cjyun.heartakecare.main.ui;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseActivity;
import com.cjyun.heartakecare.main.component.DaggerSettingsComponent;
import com.cjyun.heartakecare.main.module.SettingsModule;
import com.cjyun.heartakecare.main.presenter.SettingsPresenter;
import com.cjyun.heartakecare.main.view.SettingsView;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/8/6 0006
 * 描 述： 设置界面
 */
public class SettingsActivity extends BaseActivity<SettingsPresenter> implements SettingsView {


    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.menu)
    ImageView mMenu;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.tv_devices_id)
    TextView mDevicesId;
    @BindView(R.id.iv_come_back)
    ImageView mComeBack;

    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerSettingsComponent.builder()
                .appComponent(appComponent)
                .settingsModule(new SettingsModule(this))
                .build().inject(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        String device_id = SharedPreferencesUtils.getString(App.getContext(), "device_id", "");
        mDevicesId.setText(device_id);
        mTitle.setText(getResources().getText(R.string.settings_title));
        mTitle.setTextColor(Color.BLACK);
        mMenu.setBackground(null);
    }

    @Override
    protected void initData() {

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

    @OnClick({R.id.tv_wlan_settings, R.id.tv_gsm_settings, R.id.tv_language_select, R.id.tv_font_size, R.id.tv_check_update, R.id.tv_about, R.id.rl_come_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_wlan_settings:
                //跳转到WLANSettingsActivity
                startActivity(WLANSettingsActivity.class);
                break;
            case R.id.tv_gsm_settings:
                //跳转到GSMSettingsActivity
                startActivity(GSMDataActivity.class);
                break;
            case R.id.tv_language_select:
                //跳转到LanguageSelectActivity
                startActivity(LanguageSelectActivity.class);
                break;
            case R.id.tv_font_size:
                //跳转到FontSizeActivity
                startActivity(FontSizeActivity.class);
                break;
            case R.id.tv_check_update:
                //跳转CheckUpdate

                break;
            case R.id.tv_about:
                //跳转到AboutUsActivity
                startActivity(AboutUsActivity.class);
                break;
            case R.id.rl_come_back:
                finish();
                break;
        }
    }
}
