package com.cjyun.heartakecare.main.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.BaseAdapter;

import java.util.List;

/**
 * 创建者: vee
 * 时 间: 2016/9/26 0026
 * 描 述： TODO
 */
public class SelectTestObjectAdapter extends BaseAdapter<List<String>> {
    private Context mContext;

    public SelectTestObjectAdapter(Context context) {
        mContext = context;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_select_test_object, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(BaseAdapter.BaseViewHolder holder, int position) {
        String s = getData().get(position);
        Holder hold = (Holder) holder;
        hold.mSelectTestObjectName.setText(s);
    }

    public class Holder extends BaseViewHolder {
        public final TextView mSelectTestObjectName;
        public final CheckBox mSelectTestObjectCheckBox;

        public Holder(View itemView) {
            super(itemView);
            itemView.setLayoutParams(new ViewGroup.MarginLayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mSelectTestObjectName = (TextView) itemView.findViewById(R.id.item_tv_select_test_object);
            mSelectTestObjectCheckBox = (CheckBox) itemView.findViewById(R.id.item_cb_select_test_object);
        }
    }
}
