package com.cjyun.heartakecare.main.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseActivity;
import com.cjyun.heartakecare.main.component.DaggerLanguageSelectComponent;
import com.cjyun.heartakecare.main.module.LanguageSelectModule;
import com.cjyun.heartakecare.main.presenter.LanguageSelectPresenter;
import com.cjyun.heartakecare.main.view.LanguageSelectView;
import com.cjyun.heartakecare.utils.LanguageUtil;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/8/9 0009
 * 描 述： TODO
 */
public class LanguageSelectActivity extends BaseActivity<LanguageSelectPresenter> implements LanguageSelectView {

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.menu)
    ImageView mMenu;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.rl_come_back)
    RelativeLayout mComeBack;
    @BindView(R.id.iv_language_select_chinese)
    ImageView mIvLanguageSelectChinese;
    @BindView(R.id.ll_language_select_chinese)
    LinearLayout mLlLanguageSelectChinese;
    @BindView(R.id.iv_language_select_english)
    ImageView mIvLanguageSelectEnglish;
    @BindView(R.id.ll_language_select_english)
    LinearLayout mLlLanguageSelectEnglish;


    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerLanguageSelectComponent.builder()
                .appComponent(appComponent)
                .languageSelectModule(new LanguageSelectModule(this))
                .build().inject(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {
        setContentView(R.layout.activity_language_select);
        ButterKnife.bind(this);

        mTitle.setText(getResources().getText(R.string.language_select_title));
        mTitle.setTextColor(Color.BLACK);
        mMenu.setBackground(null);

        initLanguage();

    }

    /**
     * 初始化语言
     */
    private void initLanguage() {
        int integer = SharedPreferencesUtils.getInteger(this, "1", 0);

        if (integer == 2) {
            mIvLanguageSelectChinese.setVisibility(View.VISIBLE);
            mIvLanguageSelectEnglish.setVisibility(View.GONE);

        } else if (integer == 1) {

            mIvLanguageSelectChinese.setVisibility(View.GONE);
            mIvLanguageSelectEnglish.setVisibility(View.VISIBLE);
        }


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


    @OnClick({R.id.rl_come_back, R.id.ll_language_select_chinese, R.id.ll_language_select_english})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_come_back:
                finish();
                break;
            case R.id.ll_language_select_chinese:
                //TODO
                mIvLanguageSelectChinese.setVisibility(View.VISIBLE);
                mIvLanguageSelectEnglish.setVisibility(View.GONE);
                LanguageUtil.setLanguage(getApplicationContext(), "cn");
                finish();
                jumpActivity();
                SharedPreferencesUtils.setInteger(this, "1", 2);
                break;
            case R.id.ll_language_select_english:
                //TODO
                mIvLanguageSelectEnglish.setVisibility(View.VISIBLE);
                mIvLanguageSelectChinese.setVisibility(View.GONE);
                LanguageUtil.setLanguage(getApplicationContext(), "en");
                SharedPreferencesUtils.setInteger(this, "1", 1);
                finish();
                jumpActivity();
                break;
        }
    }

    private void jumpActivity() {
        Intent intent = new Intent(App.getContext(), SplashActivity.class);
        intent.setAction("language changed");
        startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (intent.getAction() == "language changed") {
            finish();
            startActivity(new Intent(this, SplashActivity.class));
        } else {
            super.onNewIntent(intent);
        }
    }


}
