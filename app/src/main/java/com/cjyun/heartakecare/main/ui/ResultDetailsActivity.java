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
import com.cjyun.heartakecare.bean.ResultDetailsBean;
import com.cjyun.heartakecare.main.component.DaggerResultDetailsComponent;
import com.cjyun.heartakecare.main.module.ResultDetailsModule;
import com.cjyun.heartakecare.main.presenter.ResultDetailsPresenter;
import com.cjyun.heartakecare.main.view.ResultDetailsView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/8/6 0006
 * 描 述： 结果详情
 */
public class ResultDetailsActivity extends BaseActivity<ResultDetailsPresenter> implements ResultDetailsView {
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.menu)
    ImageView mMenu;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;

    @BindView(R.id.tv_checked_object_name)
    TextView mCheckedObjectName;
    @BindView(R.id.tv_date)
    TextView mDate;
    @BindView(R.id.tv_result_Project_name)
    TextView mResultProjectName;
    @BindView(R.id.tv_reference)
    TextView mReference;
    @BindView(R.id.tv_checked_result)
    TextView mCheckedResult;
    @BindView(R.id.tv_disease)
    TextView mDisease;
    @BindView(R.id.tv_clinical)
    TextView mClinical;

    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerResultDetailsComponent.builder()
                .appComponent(appComponent)
                .resultDetailsModule(new ResultDetailsModule(this))
                .build().inject(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {
        setContentView(R.layout.activity_result_details);
        ButterKnife.bind(this);

        mTitle.setText(getResources().getText(R.string.result_details_title));
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
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    public void setData(ResultDetailsBean bean) {
        if (bean == null) {
            return;
        }
        mCheckedObjectName.setText(bean.checkedObjectName);
        mDate.setText(bean.date);
        mResultProjectName.setText(bean.checkedProjectName);
        mReference.setText(bean.resultReference);
        mClinical.setText(bean.objectClinical);
        mDisease.setText(bean.objectDisease);
        mCheckedResult.setText(bean.checkedResult);
    }

    @OnClick(R.id.rl_come_back)
    public void onClick() {
        finish();
    }



}
