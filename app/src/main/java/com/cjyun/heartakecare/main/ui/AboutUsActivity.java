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
import com.cjyun.heartakecare.main.component.DaggerAboutUsComponent;
import com.cjyun.heartakecare.main.module.AboutUsModule;
import com.cjyun.heartakecare.main.presenter.AboutUsPresenter;
import com.cjyun.heartakecare.main.view.AboutUsView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/8/8 0008
 * 描 述： 关于我们
 */
public class AboutUsActivity extends BaseActivity<AboutUsPresenter> implements AboutUsView {

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.menu)
    ImageView mMenu;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.tv_version_number)
    TextView mVersionNumber;
    @BindView(R.id.iv_come_back)
    ImageView mComeBack;

    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerAboutUsComponent.builder()
                .appComponent(appComponent)
                .aboutUsModule(new AboutUsModule(this))
                .build().inject(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {
        setContentView(R.layout.activity_about_us);
        ButterKnife.bind(this);

        mTitle.setText(getResources().getText(R.string.about_us_title));
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

    @OnClick(R.id.rl_come_back)
    public void onClick() {
        finish();
    }
}
