package com.cjyun.heartakecare.base.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.base.view.MVPView;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/7/13 0013
 * 描 述：TODO
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements MVPView {
    @Inject
    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return init();
    }

    private View init() {
        setupDaggerComponent(App.getApp(getActivity()).getAppComponent());
        mPresenter.attach(this);
        View view = initView();
        initData();
        return view;
    }

    protected abstract void setupDaggerComponent(AppComponent appComponent);

    protected abstract void initData();

    protected abstract View initView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.detach();
    }
}
