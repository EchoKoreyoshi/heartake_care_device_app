package com.cjyun.heartakecare.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseFragment;
import com.cjyun.heartakecare.main.component.DaggerCheckedComponent;
import com.cjyun.heartakecare.main.module.CheckedModule;
import com.cjyun.heartakecare.main.presenter.CheckedPresenter;
import com.cjyun.heartakecare.main.view.CheckedView;
import com.cjyun.heartakecare.main.window.SelectProjectWindow;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;
import com.cjyun.heartakecare.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/7/27 0027
 * 描 述：检测的fragment
 */
public class CheckedFragment extends BaseFragment<CheckedPresenter> implements CheckedView {

    @BindView(R.id.select_bt)
    LinearLayout selectBt;
    @BindView(R.id.select_start)
    ImageView mSelectStart;
    @BindView(R.id.ll_start_check)
    LinearLayout mStartCheck;
    @BindView(R.id.tv_pls_select_project)
    TextView mPlsSelectProject;

    private MainActivity mActivity;
    private SelectProjectWindow mWindow;
    //    private SelectTestObjectWindow mTestWindow;
    private int mTag = 0;

    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerCheckedComponent.builder().appComponent(appComponent)
                .checkedModule(new CheckedModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected View initView() {
        mActivity = (MainActivity) getActivity();
        mActivity.setTitle(getResources().getText(R.string.check_title));
        View view = View.inflate(getActivity(), R.layout.fragment_checked, null);
        return view;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }


    @OnClick(R.id.select_bt)
    public void selectProject(View v) {
        mPresenter.selectProject();
    }


    //显示选择项目
    @Override
    public void showProjectWindow(List<String> data) {
        if (mWindow == null)
            mWindow = new SelectProjectWindow(getActivity(), data, this, SelectProjectWindow.PROJECT_VIEW);
        mWindow.show();
    }

//    //显示检测对象
//    @Override
//    public void showTestObjectWindow(List<String> data) {
//        if (mTestWindow == null)
//            mTestWindow = new SelectTestObjectWindow(getActivity(), data);
//        mTestWindow.show();
//    }

    @Override
    public void setString(String src) {
        mPlsSelectProject.setText(src);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.ll_start_check)
    public void onClick() {
        boolean upload_test_data = SharedPreferencesUtils.getBoolean(getActivity(), "Upload_test_data", false);
        if (upload_test_data) {
            ToastUtils.showMessage("开始上传检测数据。");
            mPresenter.uploadTestDatas(mActivity.getApplicationContext());
            SharedPreferencesUtils.remove(getActivity(), "Upload_test_data");
        } else {
            if (!mPlsSelectProject.getText().equals(getActivity().getString(R.string.main_select_project))) {
                new SelectProjectWindow(getActivity(), new ArrayList<>(), null, SelectProjectWindow.OBJ_VIEW).show();
                mPresenter.selectTestObject();
                return;
            }

            AlertDialog alertDialog = new AlertDialog.Builder(getContext())
                    .setCancelable(true)
                    .setTitle(getResources().getText(R.string.checked_fragment_dialog_title))
                    .setMessage(getResources().getText(R.string.checked_fragment_dialog_msg))
                    .setPositiveButton(getResources().getText(R.string.checked_fragment_dialog_positivebutton), (dialog, which) -> {
                        mPresenter.selectProject();
//                    if (!mPlsSelectProject.getText().equals(getActivity().getString(R.string.main_select_project))) {
//                        mPresenter.selectTestObject();
//                    }
                        dialog.dismiss();
                    }).create();
            alertDialog.show();
        }
    }

    public void to() {
        Intent intent = new Intent(getActivity(), CheckedProjectActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
//        SelectProjectWindow = new SelectProjectWindow();
    }
}