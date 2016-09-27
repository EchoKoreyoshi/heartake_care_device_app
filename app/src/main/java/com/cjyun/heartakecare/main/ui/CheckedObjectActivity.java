package com.cjyun.heartakecare.main.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseActivity;
import com.cjyun.heartakecare.bean.CheckedObjectBean;
import com.cjyun.heartakecare.main.adapter.CheckedObjectAdapter;
import com.cjyun.heartakecare.main.component.DaggerCheckedObjectComponent;
import com.cjyun.heartakecare.main.module.CheckedObjectModule;
import com.cjyun.heartakecare.main.presenter.CheckedObjectPresenter;
import com.cjyun.heartakecare.main.view.CheckedObjectView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/8/5 0005
 * 描 述： 检测对象的界面
 */
public class CheckedObjectActivity extends BaseActivity<CheckedObjectPresenter> implements CheckedObjectView {


    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.menu)
    ImageView mMenu;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.list)
    RecyclerView mList;

    private CheckedObjectAdapter mAdapter;

    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerCheckedObjectComponent.builder()
                .appComponent(appComponent)
                .checkedObjectModule(new CheckedObjectModule(this))
                .build().inject(this);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_checked_object);
        ButterKnife.bind(this);

        mTitle.setText(getResources().getText(R.string.checked_object_title));
        mTitle.setTextColor(Color.BLACK);

        mMenu.setBackgroundResource(R.mipmap.add);

        LinearLayoutManager layout = new LinearLayoutManager(this);
        mList.setLayoutManager(layout);

        mAdapter = new CheckedObjectAdapter(this);
        mList.setAdapter(mAdapter);
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

    public void loadList(ArrayList<CheckedObjectBean> data) {
        mAdapter.setData(data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.menu, R.id.rl_come_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu:
                startActivity(AddCheckedObjectInfoActivity.class);
                break;
            case R.id.rl_come_back:
                finish();
                break;
        }
    }
}
