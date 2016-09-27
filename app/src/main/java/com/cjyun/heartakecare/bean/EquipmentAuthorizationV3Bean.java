package com.cjyun.heartakecare.bean;

/**
 * 创建者: vee
 * 时 间: 2016/9/20 0020
 * 描 述： TODO
 */
public class EquipmentAuthorizationV3Bean {

    /**
     * access_token : ca6446b993fadaa30add6149edb60b9943dd7f3f4d303fa7a30b62c49713b851
     * token_type : bearer
     * expires_in : 604800
     * refresh_token : 5f0cbe64d24d34195bf1c6df124dbf0bae618f1e834cd6b0fce632993efed7b0
     * scope : heartake_device_read heartake_device_write
     * created_at : 1473817985
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
