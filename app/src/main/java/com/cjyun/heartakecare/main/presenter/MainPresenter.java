package com.cjyun.heartakecare.main.presenter;

import android.view.View;

import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.main.model.MainModel;
import com.cjyun.heartakecare.main.ui.MainActivity;
import com.cjyun.heartakecare.main.view.MainView;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/7/20 0020
 * 描 述：TODO
 */
public class MainPresenter extends BasePresenter<MainView> {
    @Inject
    MainModel mModel;
    private MainActivity mActivity;

    @Inject
    public MainPresenter(MainActivity activity) {
        mActivity = activity;
    }

    public void menuSelect(View v) {
        switch (v.getId()) {
            case R.id.check_project:
                mActivity.showCheckProject();
                break;
            case R.id.check_object:
                mActivity.showCheckObject();
                break;
            case R.id.author:
                mActivity.showAuthorPage();
                break;
            case R.id.settings:
                mActivity.showSettingsPage();
                break;
            default:
                break;
        }
    }

}
