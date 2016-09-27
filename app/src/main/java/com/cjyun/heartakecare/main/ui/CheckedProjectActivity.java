package com.cjyun.heartakecare.main.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseActivity;
import com.cjyun.heartakecare.bean.ProjectBean;
import com.cjyun.heartakecare.main.adapter.CheckedProjectAdapter;
import com.cjyun.heartakecare.main.component.DaggerCheckedProjectComponent;
import com.cjyun.heartakecare.main.module.CheckedProjectModule;
import com.cjyun.heartakecare.main.presenter.CheckedProjectPresenter;
import com.cjyun.heartakecare.main.view.CheckedProjectView;
import com.cjyun.heartakecare.qrcode.activity.CaptureActivity;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/8/4 0004
 * 描 述： 检测项目
 */
public class CheckedProjectActivity extends BaseActivity<CheckedProjectPresenter> implements CheckedProjectView {

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

    public static final int REQUEST_CODE = 0;
    private CheckedProjectAdapter mAdapter;

    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerCheckedProjectComponent.builder()
                .appComponent(appComponent)
                .checkedProjectModule(new CheckedProjectModule(this))
                .build().inject(this);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_checked_project);
        ButterKnife.bind(this);

//        mToolbar.setNavigationIcon(R.mipmap.come_back);


        mTitle.setText(getResources().getText(R.string.checked_project_title));
        mTitle.setTextColor(Color.BLACK);

        mMenu.setBackgroundResource(R.mipmap.add);
        LinearLayoutManager layout = new LinearLayoutManager(this);
        mList.setLayoutManager(layout);

        mAdapter = new CheckedProjectAdapter(this);
        mAdapter.setOnItemClickListener((view, position) ->
                startActivity(ProjectInfoActivity.class));
        mList.setAdapter(mAdapter);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    protected void initData() {
//        mPresenter.loadData();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mPresenter.loadData();
    }

    @Override
    public void loadList(List<ProjectBean> data) {
        mAdapter.setData(data);
    }


    @OnClick({R.id.menu, R.id.rl_come_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.menu:
                AlertDialog alertDialog = new AlertDialog.Builder(this)
                        .setCancelable(true)
                        .setTitle(getResources().getText(R.string.checked_project_dialog_title))
                        .setMessage(getResources().getText(R.string.checked_project_dialog_msg))
                        .setPositiveButton(getResources().getText(R.string.checked_project_dialog_positivebutton), (dialog, which) -> {
                            Intent intent = new Intent(CheckedProjectActivity.this, CaptureActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivityForResult(intent, REQUEST_CODE);
//                            startActivity(CaptureActivity.class);
                            dialog.dismiss();
                        }).create();
                alertDialog.show();
                break;
            case R.id.rl_come_back:
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { //RESULT_OK = -1
            Bundle bundle = data.getExtras();
            String scanResult = bundle.getString("result");
          //  String toJson = new Gson().toJson(scanResult);
            //TODO：处理返回的结果
            SharedPreferencesUtils.setString(getApplicationContext(), "qrcode_json", scanResult);
            Toast.makeText(CheckedProjectActivity.this, scanResult, Toast.LENGTH_LONG).show();
        }
    }
}
