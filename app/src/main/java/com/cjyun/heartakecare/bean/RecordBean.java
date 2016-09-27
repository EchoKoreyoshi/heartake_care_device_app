package com.cjyun.heartakecare.bean;

/**
 * 创建者: vee
 * 时 间: 2016/7/25 0025
 * 描 述： 记录
 */
public class RecordBean {
    public String date;//时间
    public String username;//用户名
    public String feature;//特征

    public RecordBean(String date, String username, String feature) {
        this.date = date;
        this.feature = feature;
        this.username = username;
    }
}
