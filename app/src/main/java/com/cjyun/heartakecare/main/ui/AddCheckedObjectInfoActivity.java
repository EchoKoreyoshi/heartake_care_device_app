package com.cjyun.heartakecare.main.ui;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseActivity;
import com.cjyun.heartakecare.bean.AddCheckedObjectInfoBean;
import com.cjyun.heartakecare.main.component.DaggerAddCheckedObjectInfoComponent;
import com.cjyun.heartakecare.main.module.AddCheckedObjectInfoModule;
import com.cjyun.heartakecare.main.presenter.AddCheckedObjectInfoPresenter;
import com.cjyun.heartakecare.main.view.AddCheckedObjectInfoView;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/8/5 0005
 * 描 述： TODO
 */
public class AddCheckedObjectInfoActivity extends BaseActivity<AddCheckedObjectInfoPresenter> implements AddCheckedObjectInfoView {
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.menu)
    ImageView mMenu;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.bt_save)
    Button mBtSave;
    @BindView(R.id.tv_add_object_name)
    TextView mAddObjectName;
    @BindView(R.id.tv_add_object_age)
    TextView mAddObjectAge;
    @BindView(R.id.tv_add_object_sex)
    TextView mAddObjectSex;
    @BindView(R.id.tv_add_object_weight)
    TextView mAddObjectWeight;
    @BindView(R.id.tv_add_object_history)
    TextView mAddObjectHistory;


    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerAddCheckedObjectInfoComponent.builder()
                .appComponent(appComponent)
                .addCheckedObjectInfoModule(new AddCheckedObjectInfoModule(this))
                .build().inject(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {
        setContentView(R.layout.activity_add_checked_object_info);
        ButterKnife.bind(this);

        mTitle.setText(getResources().getText(R.string.add_checked_object_info_title));
        mTitle.setTextColor(Color.BLACK);

        mMenu.setBackground(null);


    }

    @Override
    protected void initData() {
        mPresenter.loadData();
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
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_save, R.id.rl_come_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_come_back:
                finish();
                break;
            case R.id.bt_save:
                //TODO
                SharedPreferencesUtils.setBoolean(getApplicationContext(), "Upload_test_data", true);
                mPresenter.homeUploadCheckedObject();
                finish();
                break;
        }
    }

    public void setData(AddCheckedObjectInfoBean bean) {
        if (bean == null) {
            return;
        }
        mAddObjectName.setText(bean.objectName);
        mAddObjectAge.setText(bean.objectAge);
        mAddObjectSex.setText(bean.objectSex);
        mAddObjectWeight.setText(bean.objectWeight);
        mAddObjectHistory.setText(bean.objectHistroy);
    }


}
