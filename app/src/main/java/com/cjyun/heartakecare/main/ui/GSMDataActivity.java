package com.cjyun.heartakecare.main.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseActivity;
import com.cjyun.heartakecare.main.component.DaggerGSMDataComponent;
import com.cjyun.heartakecare.main.module.GSMDataModule;
import com.cjyun.heartakecare.main.presenter.GSMDataPersenter;
import com.cjyun.heartakecare.main.view.GSMDataView;
import com.cjyun.heartakecare.utils.NetUtils;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;
import com.cjyun.heartakecare.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/8/9 0009
 * 描 述：GSM数据
 */
public class GSMDataActivity extends BaseActivity<GSMDataPersenter> implements GSMDataView {
    @BindView(R.id.iv_come_back)
    ImageView mComeBack;

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.menu)
    ImageView mMenu;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;

    @BindView(R.id.iv_gsm_data_open)
    ImageView mIvGsmDataOpen;
    @BindView(R.id.ll_gsm_data_open)
    LinearLayout mLlGsmDataOpen;
    @BindView(R.id.iv_gsm_data_off)
    ImageView mIvGsmDataOff;
    @BindView(R.id.ll_gsm_data_off)
    LinearLayout mLlGsmDataOff;

    private TelephonyManager teleManager;
    private boolean enabled;

    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerGSMDataComponent.builder()
                .appComponent(appComponent)
                .gSMDataModule(new GSMDataModule(this))
                .build().inject(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {
        setContentView(R.layout.activity_gsm_data);
        ButterKnife.bind(this);

        mTitle.setText(getResources().getText(R.string.gsm_data_title));
        mTitle.setTextColor(Color.BLACK);
        mMenu.setBackground(null);

        teleManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        ToastUtils.showMessage("new NetworkManager(this).isNetworkConnected():" + new NetUtils(this).isNetworkConnected(this));
    }

    @Override
    protected void initData() {
        int i = SharedPreferencesUtils.getInteger(getApplicationContext(), "GSM", 0);
        if (i == 1 && enabled == true) {
            try {
                new NetUtils(this).toggleGprs(enabled);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mIvGsmDataOpen.setVisibility(View.VISIBLE);
            mIvGsmDataOff.setVisibility(View.GONE);
        } else if (i == 2 && enabled == false) {
            try {
                new NetUtils(this).toggleGprs(enabled);
            } catch (Exception e) {
                e.printStackTrace();
            }
            mIvGsmDataOff.setVisibility(View.VISIBLE);
            mIvGsmDataOpen.setVisibility(View.GONE);
        }
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

    @OnClick({R.id.ll_gsm_data_open, R.id.ll_gsm_data_off, R.id.rl_come_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_come_back:
                finish();
                break;
            case R.id.ll_gsm_data_open:
                //TODO
                SharedPreferencesUtils.setInteger(getApplicationContext(), "GSM", 1);
                enabled = true;
                try {
                    new NetUtils(this).toggleGprs(enabled);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mIvGsmDataOpen.setVisibility(View.VISIBLE);
                mIvGsmDataOff.setVisibility(View.GONE);
                break;
            case R.id.ll_gsm_data_off:
                //TODO
                SharedPreferencesUtils.setInteger(getApplicationContext(), "GSM", 2);
                enabled = false;
                try {
                    new NetUtils(this).toggleGprs(enabled);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                mIvGsmDataOff.setVisibility(View.VISIBLE);
                mIvGsmDataOpen.setVisibility(View.GONE);
                break;
        }
    }
}
