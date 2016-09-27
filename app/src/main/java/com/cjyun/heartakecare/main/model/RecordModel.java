package com.cjyun.heartakecare.main.model;

import com.cjyun.heartakecare.base.listener.OnLoadDataListener;
import com.cjyun.heartakecare.bean.RecordBean;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/7/27 0027
 * 描 述：TODO
 */
public class RecordModel {
    @Inject
    public RecordModel() {
    }

    public void loadData(OnLoadDataListener<List<RecordBean>> listener){

        List<RecordBean> data = new ArrayList<>();
        data.add(new RecordBean("2016-1-1","张三","高血压"));
        data.add(new RecordBean("2016-2-9","李四","低血糖"));
        data.add(new RecordBean("2015-7-6","王麻子","高血压"));
        listener.onSuccess(data);
    }
}
