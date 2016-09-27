package com.cjyun.heartakecare.bean;

/**
 * 创建者: vee
 * 时 间: 2016/9/26 0026
 * 描 述： 试剂二维码的json
 */
public class QrcodeReagentBean {


    /**
     * project_name : 心脏型脂肪结合蛋白(h-FABP)
     * single_box_quantity : 10
     * batch : 20160926
     * availability_month : 12
     * manufactor : XXXXXXXXXXXX
     * param_scope : 6,10,15,12,8
     * serial_number : 10001011
     */

    private String project_name;
    private int single_box_quantity;
    private String batch;
    private int availability_month;
    private String manufactor;
    private String param_scope;
    private String serial_number;

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public int getSingle_box_quantity() {
        return single_box_quantity;
    }

    public void setSingle_box_quantity(int single_box_quantity) {
        this.single_box_quantity = single_box_quantity;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getAvailability_month() {
        return availability_month;
    }

    public void setAvailability_month(int availability_month) {
        this.availability_month = availability_month;
    }

    public String getManufactor() {
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactor = manufactor;
    }

    public String getParam_scope() {
        return param_scope;
    }

    public void setParam_scope(String param_scope) {
        this.param_scope = param_scope;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }
}
