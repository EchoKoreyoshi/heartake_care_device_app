package com.cjyun.heartakecare.main.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.BaseAdapter;
import com.cjyun.heartakecare.bean.RecordBean;

import java.util.List;

/**
 * 创建者: vee
 * 时 间: 2016/7/25 0025
 * 描 述： 记录的适配器
 */
public class RecordAdapter extends BaseAdapter<List<RecordBean>> {

    @Override
    public BaseAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  View.inflate(parent.getContext(), R.layout.item_record, null);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new RecordHolder(view);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseViewHolder holder, int position) {
        RecordBean bean = getData().get(position);
        RecordHolder recordHolder = (RecordHolder) holder;
        recordHolder.mDate.setText(bean.date);
        recordHolder.mUsername.setText(bean.username);
        recordHolder.mFeature.setText(bean.feature);
    }

    public class RecordHolder extends BaseAdapter.BaseViewHolder {

        public TextView mDate;
        public TextView mUsername;
        public TextView mFeature;

        public RecordHolder(View itemView) {
            super(itemView);
            mDate = (TextView) itemView.findViewById(R.id.date);
            mUsername = (TextView) itemView.findViewById(R.id.username);
            mFeature = (TextView) itemView.findViewById(R.id.feature);
        }
    }
}
