package com.cjyun.heartakecare.bean;

/**
 * 创建者: vee
 * 时 间: 2016/9/21 0021
 * 描 述： token
 */
public class RefreshTokenBean {

    /**
     * access_token : fd9acd62fce66c3ce7782a9d1ed07ba338dbaa255683ba0a4a8b06acf1eb0da5
     * token_type : bearer
     * expires_in : 604800
     * refresh_token : d071524ee4df556b07c0164e59c7d45794291ce0ea003db704ae7f7925a6142d
     * scope : heartake_device_read heartake_device_write
     * created_at : 1473818119
     */

    private String access_token;
    private String token_type;
    private int expires_in;
    private String refresh_token;
    private String scope;
    private int created_at;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public int getCreated_at() {
        return created_at;
    }

    public void setCreated_at(int created_at) {
        this.created_at = created_at;
    }
}
