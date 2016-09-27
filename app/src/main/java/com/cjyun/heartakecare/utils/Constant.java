package com.cjyun.heartakecare.utils;

/**
 * 创建者: vee
 * 时 间: 2016/7/14 0014
 * 描 述：配置参数
 */
public interface Constant {
    //网络链接和超时时间
    int CONN_TIME = 10000;
    int READ_TIME = 10000;
    int WRITE_TIME = 10000;


    //URL-->https://api.heartakecare.com/v1/device/home_auth
    //正式的域名
    //String BASE_URL = "https://api.heartakecare.com";
    //测试的域名
    //String BASE_URL = "https://heartakecare.ccd12320.com:3000";
    //临时的域名
    String BASE_URL = "https://heartakecare.ccd12320.com";

    /**
     * 设备授权
     */
    interface Authorization {

        //Basic验证码
        String BASIC_VERIFY = "Basic N2E4MWFmOTZhZjgzYjdkN2YxYTY3MDBkM2I2ZWFhMGE2NmQ3NzQ5ZmRlZmRhNGFiMzVlYzQyMWQ5NTMzMDM3OTowNzQ5NTkxODcwYWFmOGM3NTYzMzQ4Y2M5YTg1OWE3ZGRiNWFhZjhlNWJhZGE3Mjg2OGQxNzc1NmNiZjNkMTdm";
        //Application:
        String CLIENT_ID = "7a81af96af83b7d7f1a6700d3b6eaa0a66d7749fdefda4ab35ec421d95330379";
        //回转地址:
        String REDIRECT_URL = "https://heartakecare.com/callback";

        String RESPONSE_TYPE = "code";
        String SCOPE = "heartake_device_read heartake_device_write";
        String DEVICE_NAME = "heartake_device";

        String GRANT_TYPE = "authorization_code";
        String SCOPES = "heartake_device_read heartake_device_write";

    }

    /**
     * 刷新token
     */
    interface RefreshToken {
        String GRANT_TYPE = "refresh_token";
    }

    /**
     * 上传设备类型
     */
    interface UploadDeviceType {
        String HOME_USER = "home";
        String UNIT_USER = "unit";
    }

    interface DevicesAuthorize {
        String DIALOG_MSG01 = "是否同意将本设备检测的数据授权给账户为";
        String DIALOG_MSG02 = "的手机端App用户查看？";
    }
}
