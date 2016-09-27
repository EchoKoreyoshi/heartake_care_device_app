package com.cjyun.heartakecare.main.ui;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseActivity;
import com.cjyun.heartakecare.main.component.DaggerSelectComponent;
import com.cjyun.heartakecare.main.module.SelectModule;
import com.cjyun.heartakecare.main.presenter.SelectPresenter;
import com.cjyun.heartakecare.main.view.SelectView;
import com.cjyun.heartakecare.utils.SerialCtrolThread;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/7/18 0018
 * 描 述：用户选择类型界面
 */
public class SelectActivity extends BaseActivity<SelectPresenter> implements RadioGroup.OnCheckedChangeListener, SelectView {

    @BindView(R.id.select_group)
    RadioGroup mGroup;
    @BindView(R.id.select_next)
    LinearLayout mSelectNext;
    private int mCheckedId;

    private int mTag;//标记

    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerSelectComponent.builder().appComponent(appComponent)
                .selectModule(new SelectModule(this)).build().inject(this);
    }

    @Override
    protected void initView() {

        //全屏显示，隐藏title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_select);
        ButterKnife.bind(this);
        mGroup.setOnCheckedChangeListener(this);
    }

    @Override
    protected void initData() {
        SerialCtrolThread thread = new SerialCtrolThread();
        thread.start();
    }


    @OnClick(R.id.select_next)
    void onClick(View v) {
        switch (mCheckedId) {
            case R.id.bt_home:
                mTag = 1;
                showDialog();
                break;
            case R.id.bt_unit:
                mTag = 2;
                showDialog();
                break;
            default:
                break;
        }
    }

    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        mCheckedId = checkedId;
    }

    @Override
    public void showDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setCancelable(false)
                .setTitle(getResources().getText(R.string.select_dialog_title))
                .setMessage(getResources().getText(R.string.select_dialog_message))
                .setPositiveButton(getResources().getText(R.string.select_dialog_positivebutton), (dialog, which) -> {
                    dialog.dismiss();
                })
                .setNegativeButton(getResources().getText(R.string.select_dialog_negativebutton), (dialog, which) -> {
                    if (mTag == 2) {
                        startActivity(WriteUnitNameActivity.class);
                    } else {
                        mPresenter.mUploadDeviceType();
                        startActivity(MainActivity.class);
                    }
                    dialog.dismiss();
                }).create();
        alertDialog.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

/*    *//**
     * 菜单、返回键响应
     *
     * @param keyCode
     * @param event
     * @return
     *//*
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click();      //调用双击退出函数
        }
        return false;
    }

    *//**
     * 双击退出函数
     *//*
    private static Boolean isExit = false;

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            finish();
            System.exit(0);
        }
    }*/
}
