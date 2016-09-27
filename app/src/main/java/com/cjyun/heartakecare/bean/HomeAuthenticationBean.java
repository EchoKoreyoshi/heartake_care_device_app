package com.cjyun.heartakecare.bean;

import java.util.List;

/**
 * 创建者: vee
 * 时 间: 2016/9/21 0021
 * 描 述： 家庭版授权
 */
public class HomeAuthenticationBean {

    /**
     * device_id : 17
     * user_id : 3
     * id : 2
     * created_at : 2016-09-13T15:51:30.124+08:00
     * updated_at : 2016-09-13T15:51:30.124+08:00
     */

    private List<AuthListBean> auth_list;
    /**
     * id : 3
     * phone_number : 13714418201
     * email : null
     */

    private List<UserListBean> user_list;

    public List<AuthListBean> getAuth_list() {
        return auth_list;
    }

    public void setAuth_list(List<AuthListBean> auth_list) {
        this.auth_list = auth_list;
    }

    public List<UserListBean> getUser_list() {
        return user_list;
    }

    public void setUser_list(List<UserListBean> user_list) {
        this.user_list = user_list;
    }

    public static class AuthListBean {
        private int device_id;
        private int user_id;
        private int id;
        private String created_at;
        private String updated_at;

        public int getDevice_id() {
            return device_id;
        }

        public void setDevice_id(int device_id) {
            this.device_id = device_id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }
    }

    public static class UserListBean {
        private int id;
        private String phone_number;
        private String email;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
