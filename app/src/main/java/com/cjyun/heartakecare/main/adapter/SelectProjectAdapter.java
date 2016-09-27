package com.cjyun.heartakecare.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.BaseAdapter;

import java.util.List;

/**
 * 创建者: vee
 * 时 间: 2016/7/30 0030
 * 描 述：选择项目的适配器
 */
public class SelectProjectAdapter extends BaseAdapter<List<String>> {

    private Context mContext;

    public SelectProjectAdapter(Context context) {
        mContext = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_select_project, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseViewHolder holder, int position) {
        String s = getData().get(position);
        Holder hold = (Holder) holder;
        hold.mSelectProjectName.setText(s);
    }


    public class Holder extends BaseViewHolder {
        public final TextView mSelectProjectName;

        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mSelectProjectName = (TextView) itemView.findViewById(R.id.item_tv_select_project);
        }
    }
}
