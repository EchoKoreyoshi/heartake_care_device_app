package com.cjyun.heartakecare.main.window;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.ui.BaseWindow;
import com.cjyun.heartakecare.utils.DisplayUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/8/1 0001
 * 描 述：设置
 */
public class MenuWindow extends BaseWindow {

    @BindView(R.id.close)
    ImageView mDelete;
    @BindView(R.id.check_project)
    TextView mCheckProject;
    @BindView(R.id.check_object)
    TextView mCheckObject;
    @BindView(R.id.author)
    TextView mAuthor;
    @BindView(R.id.settings)
    TextView mSettings;
    private View.OnClickListener mListener;

    public MenuWindow(Context context) {
        super(context);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.window_settings;
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this, getRootView());
        setWidth(DisplayUtil.getScreenMetrics(getContext()).x);
    }

    public void show() {
        Activity context = (Activity) getContext();
        View contentView = context.findViewById(android.R.id.content);
        showAtLocation(contentView, Gravity.TOP, 0, DisplayUtil.getStatusHeight(getContext()));
    }

    @OnClick({R.id.close, R.id.check_project, R.id.check_object, R.id.author, R.id.settings})
    public void close(View view) {
        switch (view.getId()) {
            case R.id.close:
                if (isShowing())
                    dismiss();
                break;
            default:
                if (mListener != null)
                    mListener.onClick(view);
                break;
        }
    }

    public void setOnSelectListener(View.OnClickListener listener) {
        mListener = listener;
    }
}
