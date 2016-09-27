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
import com.cjyun.heartakecare.bean.ProjectInfoBean;
import com.cjyun.heartakecare.main.component.DaggerProjectInfoComponent;
import com.cjyun.heartakecare.main.module.ProjectInfoModule;
import com.cjyun.heartakecare.main.presenter.ProjectInfoPresenter;
import com.cjyun.heartakecare.main.view.ProjectInfoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/8/4 0004
 * 描 述： TODO
 */
public class ProjectInfoActivity extends BaseActivity<ProjectInfoPresenter> implements ProjectInfoView {

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.menu)
    ImageView mMenu;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;

    @BindView(R.id.tv_project_name)
    TextView mProjectName;

    @BindView(R.id.tv_count)
    TextView mCount;

    @BindView(R.id.tv_production_number)
    TextView mProductionNumber;

    @BindView(R.id.tv_term)
    TextView mTerm;

    @BindView(R.id.tv_vender)
    TextView mVender;


    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerProjectInfoComponent.builder()
                .appComponent(appComponent)
                .projectInfoModule(new ProjectInfoModule(this))
                .build().inject(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {
        setContentView(R.layout.activity_project_info);
        ButterKnife.bind(this);

//        mToolbar.setNavigationIcon(R.mipmap.come_back);
        mMenu.setBackground(null);

        mTitle.setText(getResources().getText(R.string.reagent_info));
        mTitle.setTextColor(Color.BLACK);


    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    protected void initData() {
        mPresenter.loadData();
    }


    public void setData(ProjectInfoBean bean) {
        if (bean == null) {
            return;
        }
        mProjectName.setText(bean.projectName);
        mProductionNumber.setText(bean.productionNumber);
        mCount.setText(bean.count + "");
        mTerm.setText(bean.term);
        mVender.setText(bean.vender);
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
