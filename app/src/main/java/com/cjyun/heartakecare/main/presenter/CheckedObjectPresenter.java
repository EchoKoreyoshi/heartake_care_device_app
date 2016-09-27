package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.bean.CheckedObjectBean;
import com.cjyun.heartakecare.main.ui.CheckedObjectActivity;
import com.cjyun.heartakecare.main.view.CheckedObjectView;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/8/5 0005
 * 描 述： TODO
 */
public class CheckedObjectPresenter extends BasePresenter<CheckedObjectView> {

    private CheckedObjectActivity mActivity;

    @Inject
    public CheckedObjectPresenter(CheckedObjectActivity activity) {
        mActivity = activity;
    }

    public void loadData() {
        ArrayList<CheckedObjectBean> list = new ArrayList<>();
        list.add(new CheckedObjectBean("艾弗森"));
        list.add(new CheckedObjectBean("麦迪"));
        list.add(new CheckedObjectBean("加内特"));
        list.add(new CheckedObjectBean("邓肯"));

        mActivity.loadList(list);
    }

}
