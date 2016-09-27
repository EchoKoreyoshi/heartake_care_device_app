package com.cjyun.heartakecare.main.window;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.main.adapter.SelectProjectAdapter;
import com.cjyun.heartakecare.main.adapter.SelectTestObjectAdapter;
import com.cjyun.heartakecare.main.ui.AddCheckedObjectInfoActivity;
import com.cjyun.heartakecare.main.ui.CheckedFragment;
import com.cjyun.heartakecare.main.ui.CheckedProjectActivity;
import com.cjyun.heartakecare.main.view.CheckedView;
import com.cjyun.heartakecare.utils.DisplayUtil;
import com.cjyun.heartakecare.utils.ToastUtils;
import com.cjyun.heartakecare.widget.RecycleViewDivider;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 创建者: vee
 * 时 间: 2016/7/30 0030
 * 描 述：选择项目的popupwindow
 */
public class SelectProjectWindow extends PopupWindow {

    private final CheckedView mInter;
    @BindView(R.id.list)
    RecyclerView mList;
    @BindView(R.id.window_select_project_tv)
    TextView mWindowSelectProject;
//    @BindView(R.id.et_select_test_object)
//    EditText etSelectTestObject;
//    @BindView(R.id.tv_select_test_object_add)
//    TextView tvSelectTestObjectAdd;
//    @BindView(R.id.tv_select_test_object_ok)
//    TextView tvSelectTestObjectOk;
//    @BindView(R.id.tv_select_test_object_no)
//    TextView tvSelectTestObjectNo;

    private Activity mContext;
    private List<String> mProjects;
    private SelectProjectAdapter mAdapter;
    private SelectTestObjectAdapter mTestAdapter;
    public static int PROJECT_VIEW = 0;
    public static int OBJ_VIEW = 1;
    private View mObjView;
    private int mTagerView;
    CheckedFragment mFragment = new CheckedFragment();

    public SelectProjectWindow(Activity context, List<String> projects, CheckedView inter, int tagerView) {
        super(context);
        mContext = context;
        mProjects = projects;
        mInter = inter;
        mTagerView = tagerView;
        initView();
        initData();
    }
//    public SelectProjectWindow(){
//
//    }
    private void initData() {
        mAdapter.setData(mProjects);
    }

    private void initView() {
        View rootView = View.inflate(mContext, R.layout.window_select_project, null);

        mObjView = View.inflate(mContext, R.layout.window_select_test_object, null);

        rootView.setBackgroundResource(R.drawable.rounded_popup_window);//设置圆角

        mObjView.setBackgroundResource(R.drawable.rounded_popup_window);//设置圆角

        ButterKnife.bind(this, rootView);//绑定ButterKnife


        TextView tvAdd = (TextView) mObjView.findViewById(R.id.tv_select_test_object_add);
        TextView tvOK = (TextView) mObjView.findViewById(R.id.tv_select_test_object_ok);
        TextView tvNO = (TextView) mObjView.findViewById(R.id.tv_select_test_object_no);
        tvAdd.setOnClickListener(v -> {
            mContext.startActivity(new Intent(mContext, AddCheckedObjectInfoActivity.class));
            dismiss();
        });
        tvOK.setOnClickListener(v -> {
            mContext.startActivity(new Intent(mContext, AddCheckedObjectInfoActivity.class));
            dismiss();
        });
        tvNO.setOnClickListener(v -> dismiss());

        setContentView(mTagerView == PROJECT_VIEW ? rootView : mObjView);

        mList.setLayoutManager(new LinearLayoutManager(mContext));

        mList.addItemDecoration(new RecycleViewDivider(mContext, LinearLayoutManager.HORIZONTAL, 1, Color.parseColor("#FF39F8A3")));//分割线

        setWidth((int) ((DisplayUtil.getScreenMetrics(mContext).x * 5f) / 6f));//popuwindow的宽

        setHeight((int) (DisplayUtil.getScreenMetrics(mContext).y * 2f / 3f));//popuwindow的高

        setOutsideTouchable(true);//设置外围是否可点击

        mAdapter = new SelectProjectAdapter(mContext);

        mAdapter.setOnItemClickListener((view, position) -> {
            TextView tv = (TextView) view.findViewById(R.id.item_tv_select_project);
            String s = tv.getText().toString();
            ToastUtils.showMessage("第" + position + "个条目被点击了。" + s);
            mInter.setString(s);
            dismiss();
            setContentView(mObjView);
            initSize();
            show();

        });
        mList.setAdapter(mAdapter);
        initSize();

    }

    private void initSize() {
        setWidth((int) ((DisplayUtil.getScreenMetrics(mContext).x * 5f) / 6f));//popuwindow的宽

        setHeight((int) (DisplayUtil.getScreenMetrics(mContext).y * 2f / 3f));//popuwindow的高
        ColorDrawable drawable = new ColorDrawable(Color.WHITE);

        setBackgroundDrawable(drawable);//背景

        setOutsideTouchable(true);//设置外围是否可点击
    }

    public void show() {
        View rootView = mContext.findViewById(android.R.id.content);
        showAtLocation(rootView, Gravity.CENTER, 0, 0);//显示的位置
    }

    @OnClick(R.id.window_select_project_tv)
    public void onClick() {
        mContext.startActivity(new Intent(mContext, CheckedProjectActivity.class));
    }


//    @OnClick({R.id.tv_select_test_object_add, R.id.tv_select_test_object_ok, R.id.tv_select_test_object_no})
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.tv_select_test_object_add:
//                ToastUtils.showMessage("跳转--->添加检测对象信息");
//                break;
//            case R.id.tv_select_test_object_ok:
//                ToastUtils.showMessage("跳转--->添加检测对象信息");
//
//                break;
//            case R.id.tv_select_test_object_no:
//                dismiss();
//                break;
//        }
//    }
}
