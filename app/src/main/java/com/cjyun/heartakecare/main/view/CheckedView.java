package com.cjyun.heartakecare.main.view;

import com.cjyun.heartakecare.base.view.MVPView;

import java.util.List;

/**
 * 创建者: vee
 * 时 间: 2016/7/27 0027
 * 描 述：Checked的v层
 */
public interface CheckedView extends MVPView {

    //显示选择可检查的项目
    void showProjectWindow(List<String> data);

    //设置textview里面的text
    void setString(String src);

    //显示选择检测对象
//    void showTestObjectWindow(List<String> data);

}
