package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.base.listener.OnLoadDataListener;
import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.bean.RecordBean;
import com.cjyun.heartakecare.main.model.RecordModel;
import com.cjyun.heartakecare.main.ui.RecordFragment;
import com.cjyun.heartakecare.main.view.RecordView;

import java.util.List;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/7/27 0027
 * 描 述：TODO
 */
public class RecordPresenter extends BasePresenter<RecordView> {
    private RecordFragment mFragment;

    @Inject
    RecordModel mModel;

    @Inject
    public RecordPresenter(RecordFragment fragment) {
        mFragment = fragment;
    }

    //加载数据
    public void loadData(){
        mModel.loadData(new OnLoadDataListener<List<RecordBean>>() {
            @Override
            public void onSuccess(List<RecordBean> data) {
                mFragment.setData(data);
            }

            @Override
            public void onFailed(String errorMsg) {

            }
        });
    }
}
