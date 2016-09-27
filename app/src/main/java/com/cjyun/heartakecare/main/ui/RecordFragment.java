package com.cjyun.heartakecare.main.ui;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.BaseAdapter;
import com.cjyun.heartakecare.base.ui.BaseFragment;
import com.cjyun.heartakecare.bean.RecordBean;
import com.cjyun.heartakecare.main.adapter.RecordAdapter;
import com.cjyun.heartakecare.main.component.DaggerRecordComponent;
import com.cjyun.heartakecare.main.module.RecordModule;
import com.cjyun.heartakecare.main.presenter.RecordPresenter;
import com.cjyun.heartakecare.main.view.RecordView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 创建者: vee
 * 时 间: 2016/7/27 0027
 * 描 述：记录的fragment
 */
public class RecordFragment extends BaseFragment<RecordPresenter> implements RecordView {

    @BindView(R.id.list)
    RecyclerView mList;
    private MainActivity mActivity;
    private RecordAdapter mAdapter;

    @Override
    protected void setupDaggerComponent(AppComponent appComponent) {
        DaggerRecordComponent.builder().appComponent(appComponent)
                .recordModule(new RecordModule(this)).build().inject(this);
    }

    @Override
    protected void initData() {
        mPresenter.loadData();
    }

    @Override
    protected View initView() {

        mActivity = (MainActivity) getActivity();
        mActivity.setTitle(getResources().getText(R.string.record_title));
        View view = View.inflate(getActivity(), R.layout.fragment_record, null);
        ButterKnife.bind(this, view);

        mList.setLayoutManager(new LinearLayoutManager(mActivity));
        mList.setItemAnimator(new DefaultItemAnimator());

        mAdapter = new RecordAdapter();
        mAdapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //跳转到结果详情 TODO
                Intent intent = new Intent(getContext(), ResultDetailsActivity.class);
                startActivity(intent);
            }
        });
        mList.setAdapter(mAdapter);
        return view;
    }

    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {
    }

    @Override
    public void setData(List<RecordBean> data) {
        mAdapter.setData(data);
    }
}
