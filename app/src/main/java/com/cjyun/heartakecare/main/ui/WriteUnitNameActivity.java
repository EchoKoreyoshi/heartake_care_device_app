package com.cjyun.heartakecare.main.ui;

import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseActivity;
import com.cjyun.heartakecare.main.component.DaggerWriteUnitNameComponent;
import com.cjyun.heartakecare.main.module.WriteUnitNameModule;
import com.cjyun.heartakecare.main.presenter.WriteUnitNamePresenter;
import com.cjyun.heartakecare.main.view.WriteUnitNameView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/8/6 0006
 * 描 述： 填写单位名称
 */
public class WriteUnitNameActivity extends BaseActivity<WriteUnitNamePresenter> implements WriteUnitNameView {
    @BindView(R.id.et_write_unit_name)
    EditText mUnitName;
    @BindView(R.id.select_next)
    TextView mNext;

    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerWriteUnitNameComponent.builder()
                .appComponent(appComponent)
                .writeUnitNameModule(new WriteUnitNameModule(this))
                .build().inject(this);
    }

    @Override
    protected void initView() {

        //全屏显示，隐藏title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_write_unit_name);
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


    @OnClick(R.id.select_next)
    public void onClick() {
        if (mUnitName.getText().toString().equals("")) {
            Toast.makeText(this, "请输入单位名称！", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(MainActivity.class);
        }
    }
}
