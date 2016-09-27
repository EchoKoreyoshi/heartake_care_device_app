package com.cjyun.heartakecare.main.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseActivity;
import com.cjyun.heartakecare.main.component.DaggerEquipmentAuthorizationComponent;
import com.cjyun.heartakecare.main.module.EquipmentAuthorizationModule;
import com.cjyun.heartakecare.main.presenter.EquipmentAuthorizationPresenter;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/9/21 0021
 * 描 述： 设备授权
 */
public class EquipmentAuthorizationActivity extends BaseActivity<EquipmentAuthorizationPresenter> {


    @BindView(R.id.bt_step1)
    Button mStep1;
    @BindView(R.id.bt_step2)
    Button mStep2;
    @BindView(R.id.bt_step3)
    Button mStep3;
    @BindView(R.id.step_next)
    LinearLayout mNext;

    private int mTag = 0;

    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerEquipmentAuthorizationComponent.builder()
                .appComponent(appComponent)
                .equipmentAuthorizationModule(new EquipmentAuthorizationModule(this))
                .build().inject(this);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_equipment_authorization);
        ButterKnife.bind(this);
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


    @OnClick({R.id.bt_step1, R.id.bt_step2, R.id.bt_step3, R.id.step_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_step1:
                if (mTag == 0) {
                    mPresenter.getAuthorizationkensV1();
                }
                break;
            case R.id.bt_step2:
                mPresenter.getAuthorizationkensV2();
                break;
            case R.id.bt_step3:
                mPresenter.getAuthorizationkensV3();
                break;
            case R.id.step_next:
                //TODO 验证token
                int selectActivityTag = SharedPreferencesUtils.getInteger(App.getContext(), "SelectActivityTag", 0);
                mPresenter.goToAuthenticationToken();
                if (selectActivityTag == 1) {
                    startActivity(MainActivity.class);
                } else {
                    startActivity(SelectActivity.class);
                }
                break;
        }
    }

    public void setMtag(int i) {
        mTag = i;
    }
}
