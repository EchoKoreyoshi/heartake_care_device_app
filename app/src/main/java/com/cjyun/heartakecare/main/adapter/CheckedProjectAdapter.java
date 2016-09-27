package com.cjyun.heartakecare.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.BaseAdapter;
import com.cjyun.heartakecare.bean.ProjectBean;

import java.util.List;

/**
 * 创建者: vee
 * 时 间: 2016/8/4 0004
 * 描 述： TODO
 */
public class CheckedProjectAdapter extends BaseAdapter<List<ProjectBean>>{
    private Context mContext;

    public CheckedProjectAdapter(Context context) {
        mContext = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_checked_project, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseViewHolder holder, int position) {
        ProjectBean bean = getData().get(position);
        Holder hold = (Holder) holder;
        hold.mName.setText(bean.projectName);
        hold.mRemainCount.setText(mContext.getString(R.string.remain_count, bean.remainCount));
    }


    public class Holder extends BaseViewHolder {
        public final TextView mName;
        public final TextView mRemainCount;

        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mName = (TextView) itemView.findViewById(R.id.name);
            mRemainCount = (TextView) itemView.findViewById(R.id.remain_count);
        }
    }
}
