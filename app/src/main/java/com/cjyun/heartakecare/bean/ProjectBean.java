package com.cjyun.heartakecare.bean;

/**
 * 创建者: vee
 * 时 间: 2016/8/4 0004
 * 描 述： 检测项目
 */
public class ProjectBean {
    public String projectName;
    public int remainCount;

    public ProjectBean(String projectName, int remainCount) {
        this.projectName = projectName;
        this.remainCount = remainCount;
    }
}
