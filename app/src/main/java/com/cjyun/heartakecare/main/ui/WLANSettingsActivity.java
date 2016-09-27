package com.cjyun.heartakecare.main.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseActivity;
import com.cjyun.heartakecare.bean.WifiBean;
import com.cjyun.heartakecare.main.adapter.WifiAdapter;
import com.cjyun.heartakecare.main.component.DaggerWLANSettingsComponent;
import com.cjyun.heartakecare.main.module.WLANSettingsModule;
import com.cjyun.heartakecare.main.presenter.WLANSettingsPresenter;
import com.cjyun.heartakecare.main.view.WLANSettingsView;
import com.cjyun.heartakecare.utils.WifiUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/8/11 0011
 * 描 述： TODO
 */
public class WLANSettingsActivity extends BaseActivity<WLANSettingsPresenter> implements WLANSettingsView, AdapterView.OnItemClickListener {
    @BindView(R.id.iv_come_back)
    ImageView ivComeBack;
    @BindView(R.id.rl_come_back)
    RelativeLayout mComeBack;
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.menu)
    ImageView mMenu;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    @BindView(R.id.list)
    ListView mList;


    private ScanResult mScanResult;//扫描结果
    private List<ScanResult> list;
    private WifiAdapter mAdapter;
    private WifiUtils mWifiUtils;
    private ArrayList<WifiBean> mWifiBeen = new ArrayList<>();

    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerWLANSettingsComponent.builder()
                .appComponent(appComponent)
                .wLANSettingsModule(new WLANSettingsModule(this))
                .build().inject(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {
        setContentView(R.layout.activity_wlan_settings);
        ButterKnife.bind(this);
        mTitle.setText(R.string.wlan_settings_activity_title);
        mTitle.setTextColor(Color.BLACK);
        mMenu.setBackground(null);

        mWifiUtils = new WifiUtils(WLANSettingsActivity.this);

        if (mWifiUtils.getWifiState() == WifiManager.WIFI_STATE_DISABLED) {
            Toast.makeText(this,"正在打开wifi",Toast.LENGTH_SHORT).show();
//            ToastUtils.showMessage("正在打开wifi");
            if (mWifiUtils.OpenWifi()){
                Toast.makeText(this,"wifi打开成功",Toast.LENGTH_SHORT).show();
//                ToastUtils.showMessage("wifi打开成功！");
            }
        }

        ArrayList<WifiBean> allNetWorkList = getAllNetWorkList();
        if (allNetWorkList != null) {
            mAdapter = new WifiAdapter(this, allNetWorkList);
        }
        mList.setAdapter(mAdapter);

        mList.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        final String ssid = mWifiBeen.get(position).getSsid();
        //查看以前是否也配置过这个网络
        final WifiConfiguration wifiConfiguration = mWifiUtils.IsExsits(ssid);
        if (null == wifiConfiguration) {
            setMessage(ssid);
        } else {
            mWifiUtils.Connect(wifiConfiguration);
        }
    }

    private void setMessage(final String ssid) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(WLANSettingsActivity.this);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout lay = (LinearLayout) inflater.inflate(R.layout.item_wifi_passwd, null);
        dialog.setView(lay);
        final EditText pwd = (EditText) lay.findViewById(R.id.wifi_pwd_edit);
        dialog.setTitle(ssid);
        dialog.setPositiveButton("确定", (dialog1, which) -> {
            // TODO Auto-generated method stub

            String pwdStr = pwd.getText().toString();
            boolean flag = mWifiUtils.Connect(ssid, pwdStr, WifiUtils.WifiCipherType.WIFICIPHER_WPA);
            if (flag) {
                Toast.makeText(getApplicationContext(), "正在连接，请稍后", Toast.LENGTH_SHORT).show();
            } else {
                showLog("链接错误");
            }
        }).setNegativeButton("取消", (dialog1, which) -> {
            // TODO Auto-generated method stub

        }).create();
        dialog.show();
    }


    /**
     * 得到所有的网络链接的列表
     *
     * @return wifibean
     */
    private ArrayList<WifiBean> getAllNetWorkList() {
        // 每次点击扫描之前清空上一次的扫描结果
        mWifiBeen.clear();
        // 开始扫描网络
        mWifiUtils.startScan();
        //扫描后的列表
        list = mWifiUtils.getWifiList();
        //wifiBean
        WifiBean bean;
        if (list != null) {
            //遍历
            for (int i = 0; i < list.size(); i++) {
                // 得到扫描结果
                mScanResult = list.get(i);
                bean = new WifiBean();
                bean.setSsid(mScanResult.SSID);
                bean.setBssid(mScanResult.BSSID);
                bean.setCapabilities(mScanResult.capabilities);
                bean.setFrequency(mScanResult.frequency);
                bean.setLevel(mScanResult.level);
                mWifiBeen.add(bean);
            }
        }
        return mWifiBeen;
    }

    /**
     * 提示信息对话框
     *
     * @param msg
     */
    private void showLog(final String msg) {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... params) {
                // TODO Auto-generated method stub
                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                // TODO Auto-generated method stub
                super.onPostExecute(result);
                Dialog dialog = new AlertDialog.Builder(WLANSettingsActivity.this).setTitle("提示").setMessage(msg).setNegativeButton("确定", (dialog1, which) -> {
                    // TODO Auto-generated method stub

                }).create();// 创建
                // 显示对话框
                dialog.show();
            }

        }.execute();
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

    @OnClick(R.id.rl_come_back)
    public void onClick() {
        finish();
    }

}
