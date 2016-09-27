package com.cjyun.heartakecare.bean;

/**
 * 创建者: vee
 * 时 间: 2016/9/27 0027
 * 描 述： 检测数据的bean
 */
public class TestDataBean {

    /**
     * name : wanger
     * qrcode_serial_number : 10001011
     * result : 3ng/ml
     * disease : 心梗
     * interpretation : 阴性
     * t1 : T1
     * t2 : T2
     * c1 : C1
     * test_time : 2016-09-27/02: 47: 57
     */

    private String name;
    private String qrcode_serial_number;
    private String result;
    private String disease;
    private String interpretation;
    private String t1;
    private String t2;
    private String c1;
    private String test_time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQrcode_serial_number() {
        return qrcode_serial_number;
    }

    public void setQrcode_serial_number(String qrcode_serial_number) {
        this.qrcode_serial_number = qrcode_serial_number;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getInterpretation() {
        return interpretation;
    }

    public void setInterpretation(String interpretation) {
        this.interpretation = interpretation;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getTest_time() {
        return test_time;
    }

    public void setTest_time(String test_time) {
        this.test_time = test_time;
    }
}
