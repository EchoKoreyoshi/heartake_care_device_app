package com.cjyun.heartakecare.main.view;

import com.cjyun.heartakecare.base.view.MVPView;
import com.cjyun.heartakecare.bean.RecordBean;

import java.util.List;

/**
 * 创建者: vee
 * 时 间: 2016/7/27 0027
 * 描 述：TODO
 */
public interface RecordView extends MVPView{
    //设置数据
    void setData(List<RecordBean> data);
}
