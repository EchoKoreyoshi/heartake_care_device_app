package com.cjyun.heartakecare.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.BaseAdapter;
import com.cjyun.heartakecare.bean.CheckedObjectBean;

import java.util.List;

/**
 * 创建者: vee
 * 时 间: 2016/8/5 0005
 * 描 述： TODO
 */
public class CheckedObjectAdapter extends BaseAdapter<List<CheckedObjectBean>> {

    private Context mContext;

    public CheckedObjectAdapter(Context context) {
        mContext = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_checked_object, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseViewHolder holder, int position) {
        CheckedObjectBean objectBean = getData().get(position);
        Holder hold = (Holder) holder;
        hold.mObjectName.setText(objectBean.objectName);

    }

    public class Holder extends BaseViewHolder {
        private TextView mObjectName;

        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mObjectName = (TextView) itemView.findViewById(R.id.tv_object_name);
        }
    }
}
