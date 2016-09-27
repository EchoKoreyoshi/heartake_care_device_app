package com.cjyun.heartakecare.main.presenter;

import android.content.Context;

import com.cjyun.heartakecare.base.listener.OnLoadDataListener;
import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.bean.HomeUploadDataBean;
import com.cjyun.heartakecare.main.model.CheckedModel;
import com.cjyun.heartakecare.main.ui.CheckedFragment;
import com.cjyun.heartakecare.main.view.CheckedView;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;
import com.cjyun.heartakecare.utils.ToastUtils;
import com.socks.library.KLog;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/7/27 0027
 * 描 述：TODO
 */
public class CheckedPresenter extends BasePresenter<CheckedView> {
    @Inject
    CheckedModel mModel;

    @Inject
    public CheckedPresenter() {
    }

    CheckedFragment mFragment = new CheckedFragment();

    /**
     * 选择的项目
     */
    public void selectProject() {
        ArrayList<String> list = new ArrayList<>();
        list.add("心脏型脂肪酸结合蛋白(h-FABP)");
        list.add("心肌肌蛋白l(cTnl)");
        list.add("氨基末端脑钠肽前体(NT-proBNP)");
        list.add("生长刺激表达基因2蛋白(ST2)");
        list.add("心脏型脂肪酸结合蛋白(D-Dimer)");
        list.add("心脏型脂肪酸结合蛋白(h-FABP)");
        list.add("心肌肌蛋白l(cTnl)");
        list.add("氨基末端脑钠肽前体(NT-proBNP)");
        list.add("生长刺激表达基因2蛋白(ST2)");
        list.add("心脏型脂肪酸结合蛋白(D-Dimer)");
        list.add("心脏型脂肪酸结合蛋白(h-FABP)");
        list.add("心肌肌蛋白l(cTnl)");
        list.add("氨基末端脑钠肽前体(NT-proBNP)");
        list.add("生长刺激表达基因2蛋白(ST2)");
        list.add("心脏型脂肪酸结合蛋白(D-Dimer)");
        list.add("心脏型脂肪酸结合蛋白(h-FABP)");
        list.add("心肌肌蛋白l(cTnl)");
        list.add("氨基末端脑钠肽前体(NT-proBNP)");
        list.add("生长刺激表达基因2蛋白(ST2)");
        list.add("心脏型脂肪酸结合蛋白(D-Dimer)");
        CheckedFragment fragment = (CheckedFragment) getView();
        fragment.showProjectWindow(list);
    }

    /**
     * 选择的检测对象
     */
    public void selectTestObject() {
        ArrayList<String> list = new ArrayList<>();
        list.add("自己");
        list.add("老爸");
        list.add("张三");
        list.add("李四");
        list.add("王五");
        CheckedFragment fragment = (CheckedFragment) getView();
        fragment.showProjectWindow(list);
    }

    /**
     * 上传检测数据
     */
    public void uploadTestDatas(Context context) {
        mModel.uploadTestData(context, new OnLoadDataListener<HomeUploadDataBean>() {
            @Override
            public void onSuccess(HomeUploadDataBean data) {
                String status = data.getStatus();
                KLog.e("上传检测数据：" + status);
                ToastUtils.showMessage("上传检测数据：" + status);
            }

            @Override
            public void onFailed(String errorMsg) {
                SharedPreferencesUtils.remove(context, "Upload_test_data");
                KLog.e(errorMsg);
            }
        });
    }
}
