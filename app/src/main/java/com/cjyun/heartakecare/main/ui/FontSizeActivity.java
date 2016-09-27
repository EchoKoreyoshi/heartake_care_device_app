package com.cjyun.heartakecare.main.ui;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseActivity;
import com.cjyun.heartakecare.main.component.DaggerFontSizeComponent;
import com.cjyun.heartakecare.main.module.FontSizeModule;
import com.cjyun.heartakecare.main.presenter.FontSizePresenter;
import com.cjyun.heartakecare.main.view.FontSizeView;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;
import com.cjyun.heartakecare.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/8/9 0009
 * 描 述： 字体大小
 */
public class FontSizeActivity extends BaseActivity<FontSizePresenter> implements FontSizeView {

    @BindView(R.id.iv_come_back)
    ImageView mComeBack;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.menu)
    ImageView mMenu;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;

    @BindView(R.id.iv_font_size_large)
    ImageView mIvFontSizeLarge;
    @BindView(R.id.ll_font_size_large)
    LinearLayout mLlFontSizeLarge;

    @BindView(R.id.iv_font_size_medium)
    ImageView mIvFontSizeMedium;
    @BindView(R.id.ll_font_size_medium)
    LinearLayout mLlFontSizeMedium;

    @BindView(R.id.iv_font_size_small)
    ImageView mIvFontSizeSmall;
    @BindView(R.id.ll_font_size_small)
    LinearLayout mLlFontSizeSmall;


    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerFontSizeComponent.builder()
                .appComponent(appComponent)
                .fontSizeModule(new FontSizeModule(this))
                .build().inject(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {
        setContentView(R.layout.activity_font_size);
        ButterKnife.bind(this);

        mTitle.setText(getResources().getText(R.string.font_size_activity_title));
        mTitle.setTextColor(Color.BLACK);
        mMenu.setBackground(null);
    }

    @Override
    protected void initData() {
        int mode = SharedPreferencesUtils.getInteger(getApplicationContext(), "Theme_Font", 2);
        if (mode == 1) {
            mIvFontSizeLarge.setVisibility(View.VISIBLE);
            mIvFontSizeMedium.setVisibility(View.GONE);
            mIvFontSizeSmall.setVisibility(View.GONE);
        } else if (mode == -1 || mode == 2) {
            mIvFontSizeLarge.setVisibility(View.GONE);
            mIvFontSizeMedium.setVisibility(View.VISIBLE);
            mIvFontSizeSmall.setVisibility(View.GONE);
        } else if (mode == 3) {
            mIvFontSizeLarge.setVisibility(View.GONE);
            mIvFontSizeSmall.setVisibility(View.VISIBLE);
            mIvFontSizeMedium.setVisibility(View.GONE);
        }
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


    @OnClick({R.id.rl_come_back, R.id.ll_font_size_large, R.id.ll_font_size_medium, R.id.ll_font_size_small})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_come_back:
                finish();
                break;
            case R.id.ll_font_size_large:
                //TODO
                mIvFontSizeLarge.setVisibility(View.VISIBLE);
                mIvFontSizeMedium.setVisibility(View.GONE);
                mIvFontSizeSmall.setVisibility(View.GONE);

                SharedPreferencesUtils.setInteger(getApplicationContext(), "Theme_Font", 1);
                finish();
                startActivity(SplashActivity.class);
//                jumpActivity();
                ToastUtils.showMessage("大字体");
                break;
            case R.id.ll_font_size_medium:
                //TODO
                mIvFontSizeLarge.setVisibility(View.GONE);
                mIvFontSizeMedium.setVisibility(View.VISIBLE);
                mIvFontSizeSmall.setVisibility(View.GONE);

                SharedPreferencesUtils.setInteger(getApplicationContext(), "Theme_Font", 2);
                finish();
                startActivity(SplashActivity.class);
//                jumpActivity();
                ToastUtils.showMessage("中字体");
                break;
            case R.id.ll_font_size_small:
                //TODO
                mIvFontSizeLarge.setVisibility(View.GONE);
                mIvFontSizeSmall.setVisibility(View.VISIBLE);
                mIvFontSizeMedium.setVisibility(View.GONE);

                SharedPreferencesUtils.setInteger(getApplicationContext(), "Theme_Font", 3);
                finish();
                startActivity(SplashActivity.class);
//                jumpActivity();

                ToastUtils.showMessage("小字体");
                break;
        }
    }

//    private void jumpActivity() {
//        Intent intent = new Intent(App.getContext(), SplashActivity.class);
////        intent.setAction("font size changed");
//        startActivity(intent);
//    }

//    @Override
//    protected void onNewIntent(Intent intent) {
//        if (intent.getAction() == "font size changed") {
//            finish();
//            startActivity(new Intent(this, SplashActivity.class));
//        } else {
//            super.onNewIntent(intent);
//        }
//    }
}
