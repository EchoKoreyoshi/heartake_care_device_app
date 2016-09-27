package com.cjyun.heartakecare.main.ui;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseActivity;
import com.cjyun.heartakecare.main.component.DaggerScanCodeComponent;
import com.cjyun.heartakecare.main.module.ScanCodeModule;
import com.cjyun.heartakecare.main.presenter.ScanCodePresenter;
import com.cjyun.heartakecare.main.view.ScanCodeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/8/4 0004
 * 描 述：扫码
 */
public class ScanCodeActivity extends BaseActivity<ScanCodePresenter> implements ScanCodeView {
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.menu)
    ImageView mMenu;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;

    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerScanCodeComponent.builder()
                .appComponent(appComponent)
                .scanCodeModule(new ScanCodeModule(this))
                .build().inject(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {
        setContentView(R.layout.activity_scan_code);
        ButterKnife.bind(this);

        mMenu.setBackground(null);
        mTitle.setText(getResources().getText(R.string.scan_code_title));
        mTitle.setTextColor(Color.BLACK);

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

    @OnClick(R.id.rl_come_back)
    public void onClick() {
        finish();
    }
}
