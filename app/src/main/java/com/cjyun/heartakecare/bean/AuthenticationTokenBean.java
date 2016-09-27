package com.cjyun.heartakecare.bean;

/**
 * 创建者: vee
 * 时 间: 2016/9/21 0021
 * 描 述： 验证token
 */
public class AuthenticationTokenBean {


    /**
     * status : success
     * code : 1
     */

    private String status;
    private int code;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
