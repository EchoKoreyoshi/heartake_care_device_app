package com.cjyun.heartakecare.base.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.base.view.MVPView;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/7/13 0013
 * 描 述： 页面基类
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements MVPView {

    @Inject
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);//透明导航栏
        }

        //改变字体大小
        int mode = SharedPreferencesUtils.getInteger(getApplicationContext(), "Theme_Font", -1);
//        KLog.a("Font Size  " + mode);
        if (mode == 1) {
            this.setTheme(R.style.Theme_Large);
        } else if (mode == -1 || mode == 2) {
            this.setTheme(R.style.Theme_Medium);
        } else if (mode == 3) {
            this.setTheme(R.style.Theme_Small);
        }
        init();
    }


    private void init() {
        setupDaggerComponent(App.getApp(this).getAppComponent());
        mPresenter.attach(this);
        initView();
        initData();
    }

    protected abstract void setupDaggerComponent(AppComponent appComponent);

    protected abstract void initView();

    protected abstract void initData();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detach();
    }

    //开启一个界面
    public void startActivity(Class targetActivity) {
        Intent intent = new Intent(this, targetActivity);
        this.startActivity(intent);
    }


}
