package com.cjyun.heartakecare.main.view;

import com.cjyun.heartakecare.base.view.MVPView;
import com.cjyun.heartakecare.bean.ProjectBean;

import java.util.List;

/**
 * 创建者: vee
 * 时 间: 2016/8/4 0004
 * 描 述： TODO
 */
public interface CheckedProjectView extends MVPView{
    void loadList(List<ProjectBean> data);
}
