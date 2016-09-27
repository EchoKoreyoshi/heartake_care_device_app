package com.cjyun.heartakecare.main.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseActivity;
import com.cjyun.heartakecare.main.component.DaggerMainComponent;
import com.cjyun.heartakecare.main.module.MainModule;
import com.cjyun.heartakecare.main.presenter.MainPresenter;
import com.cjyun.heartakecare.main.view.MainView;
import com.cjyun.heartakecare.main.window.MenuWindow;
import com.cjyun.heartakecare.widget.FragmentTabHost;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/7/20 0020
 * 描 述：TODO
 */
public class MainActivity extends BaseActivity<MainPresenter> implements MainView, TabHost.OnTabChangeListener {

    public static final String TAG_CHECKED = "checked";
    public static final String TAG_RECORD = "record";

    @BindView(R.id.iv_come_back)
    ImageView mComeBack;
    @BindView(R.id.appbar)
    AppBarLayout mAppbar;
    private MenuWindow mWindow;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.tab_content)
    FragmentTabHost mTabContent;

    @BindView(R.id.title)
    TextView mTitle;

    @BindView(R.id.menu)
    ImageView mMenu;

    //tabhost的text数组
    int[] titles = {R.string.tab_host_check, R.string.tab_host_record};
    //tabhost的图片数组
    int[] icons = {R.drawable.selector_check, R.drawable.selector_record};
    //标记
    String[] tags = {TAG_CHECKED, TAG_RECORD};
    //Fragment.class
    Class[] mFragments = {CheckedFragment.class, RecordFragment.class};

    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerMainComponent.builder().appComponent(appComponent)
                .mainModule(new MainModule(this)).build().inject(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);

        //隐藏默认的title
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mTabContent.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        mTabContent.getTabWidget().setDividerDrawable(null);
        mTabContent.setOnTabChangedListener(this);
        for (int i = 0; i < titles.length; i++) {
            mTabContent.addTab(getTab(i), mFragments[i], null);
        }

        mComeBack.setBackground(null);
        mAppbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
    }


    private TabHost.TabSpec getTab(int i) {

        TabHost.TabSpec spec = mTabContent.newTabSpec(tags[i]);

        View view = View.inflate(this, R.layout.tab_select, null);

        TextView title = (TextView) view.findViewById(R.id.tab_title);

        ImageView icon = (ImageView) view.findViewById(R.id.tab_icon);

        title.setText(titles[i]);

        icon.setBackgroundResource(icons[i]);

        spec.setIndicator(view);
        return spec;
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.menu})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.menu:
                showMenu();
                break;
            default:
                break;
        }
    }

    //显示menu选项
    private void showMenu() {
        if (mWindow == null) {
            mWindow = new MenuWindow(this);
            mWindow.setOnSelectListener(v -> mPresenter.menuSelect(v));
        }
        if (!mWindow.isShowing())
            mWindow.show();
    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showCheckProject() {
        //跳转到CheckedProjectActivity
        startActivity(CheckedProjectActivity.class);
        Toast.makeText(this, "showCheckProject", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCheckObject() {
        //跳转到CheckObjectActivity
        startActivity(CheckedObjectActivity.class);
        Toast.makeText(this, "showCheckObject", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAuthorPage() {
        //跳转到DevicesAuthrizeActivity
        startActivity(DevicesAuthorizeActivity.class);
        Toast.makeText(this, "showAuthorPage", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSettingsPage() {
        //跳转到SettingsActivity
        startActivity(SettingsActivity.class);
        Toast.makeText(this, "showSettingsPage", Toast.LENGTH_SHORT).show();
    }

    /**
     * tabhost改变时监听
     *
     * @param tabId
     */
    @Override
    public void onTabChanged(String tabId) {
        mTitle.setText(TAG_CHECKED.equals(tabId) ? getResources().getText(R.string.check_title) : getResources().getText(R.string.record_title));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    /**
     * 菜单、返回键响应
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click();      //调用双击退出函数
        }
        return false;
    }

    /**
     * 双击退出函数
     */
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
    }
}
