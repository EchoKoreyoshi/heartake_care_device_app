package com.cjyun.heartakecare.data.api;

import com.cjyun.heartakecare.bean.AuthenticationTokenBean;
import com.cjyun.heartakecare.bean.BindReagentBean;
import com.cjyun.heartakecare.bean.ChangeUnitNameBean;
import com.cjyun.heartakecare.bean.CreateUnitNameBean;
import com.cjyun.heartakecare.bean.EquipmentAuthorizationV1Bean;
import com.cjyun.heartakecare.bean.EquipmentAuthorizationV2Bean;
import com.cjyun.heartakecare.bean.EquipmentAuthorizationV3Bean;
import com.cjyun.heartakecare.bean.HomeAuthenticationBean;
import com.cjyun.heartakecare.bean.HomeAuthorizeToAppBean;
import com.cjyun.heartakecare.bean.HomeUploadDataBean;
import com.cjyun.heartakecare.bean.HomeUploadObjBean;
import com.cjyun.heartakecare.bean.RefreshTokenBean;
import com.cjyun.heartakecare.bean.UnitUploadDataBean;
import com.cjyun.heartakecare.bean.UploadDeviceTypeBean;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 创建者: vee
 * 时 间: 2016/7/14 0014
 * 描 述： 网络数据
 */
public interface ApiServer {

    //设备授权第一步
    @GET("/oauth/limited_authorize")
    Observable<EquipmentAuthorizationV1Bean> getAuthorizationV1(@Header("Authorization") String basic,
                                                                @Query("client_id") String client_id,
                                                                @Query("redirect_uri") String redirect_uri,
                                                                @Query("response_type") String response_type,
                                                                @Query("scope") String scope,
                                                                @Query("device_name") String device_name,
                                                                @Query("device_id") String device_id);

    //设备授权第二步
    @GET("/oauth/limited_authorize")
    Observable<EquipmentAuthorizationV2Bean> getAuthorizationV2(@Header("Authorization") String basic,
                                                                @Query("client_id") String client_id,
                                                                @Query("redirect_uri") String redirect_uri,
                                                                @Query("response_type") String response_type,
                                                                @Query("scope") String scope,
                                                                @Query("device_name") String device_name,
                                                                @Query("device_id") String device_id);

    //设备授权第三步:得到token
    @POST("/oauth/token")
    Observable<EquipmentAuthorizationV3Bean> getAuthorizationV3(@Header("Authorization") String basic,
                                                                @Query("grant_type") String grant_type,
                                                                @Query("code") String code,
                                                                @Query("client_id") String client_id,
                                                                @Query("Scopes") String Scopes,
                                                                @Query("redirect_uri") String redirect_uri);

    //验证token
    @GET("/develop/device_token_test")
    Observable<AuthenticationTokenBean> AuthenticationToken(@Header("Authorization") String token);


    //token过期刷新token
    @POST("/oauth/token")
    Observable<RefreshTokenBean> refreshToken(@Header("Authorization") String basic,
                                              @Query("grant_type") String grant_type,
                                              @Query("refresh_token") String refresh_token);


    //上传设备类型
    @POST("/v1/device/scope_type")
    Observable<UploadDeviceTypeBean> UploadDeviceType(@Header("Authorization") String token,
                                                      @Query("serial_number") String serial_number,
                                                      @Query("scope_type") String scope_type);

    //家庭版获取授权
    @GET("/v1/device/home_auth")
    Observable<HomeAuthenticationBean> homeAuthentication(@Header("Authorization") String token,
                                                          @Query("serial_number") String serial_number);

    //家庭版授权给App-->user_id从家庭版获取授权获得
    @POST("/v1/device/home_auth")
    Observable<HomeAuthorizeToAppBean> homeAuthorizeToApp(@Header("Authorization") String token,
                                                          @Query("serial_number") String serial_number,
                                                          @Query("user_id") int user_id);

    //家庭版上传检测数据
    @POST("/v1/device/home_data")
    Observable<HomeUploadDataBean> homeUploadData(@Header("Authorization") String token,
                                                  @Query("serial_number") String serial_number,
                                                  @Query("datas") List<String> datas);

    //家庭版上传检测对象 v1/device/home_obj
    @POST("/v1/device/home_obj")
    Observable<HomeUploadObjBean> homeUploadObject(@Header("Authorization") String token,
                                                   @Query("serial_number") String serial_number,
                                                   @Query("name") String name,
                                                   @Query("age") String age,
                                                   @Query("sex") Integer sex,
                                                   @Query("weight") String weight,
                                                   @Query("medical_teco") String medical_teco);

    //绑定试剂
    @POST("/v1/device/qrcode")
    Observable<BindReagentBean> bindReagent(@Header("Authorization") String token,
                                            @Query("serial_number") String serial_number,
                                            @Query("qrcode_serial_number") String qrcode_serial_number);

    //单位版创建单位名称
    @POST("/v1/device/unit_name")
    Observable<CreateUnitNameBean> createUnitName(@Header("Authorization") String token,
                                                  @Query("serial_number") String serial_number,
                                                  @Query("unit_name") String unit_name);

    //单位版修改单位名称
    @PUT("/v1/device/unit_name")
    Observable<ChangeUnitNameBean> changeUnitName(@Header("Authorization") String token,
                                                  @Query("serial_number") String serial_number,
                                                  @Query("unit_name") String unit_name);

    //单位版上传检测数据
    @POST("/v1/device/unit_data")
    Observable<UnitUploadDataBean> unitUploadData(@Header("Authorization") String token,
                                                  @Query("serial_number") String serial_number,
                                                  @Query("user_serial_number") String user_serial_number,
                                                  @Query("qrcode_serial_number") String qrcode_serial_number,
                                                  @Query("result") String result,
                                                  @Query("disease") String disease,
                                                  @Query("interpretation") String interpretation,
                                                  @Query("t1") String t1,
                                                  @Query("t2") String t2,
                                                  @Query("c1") String c1,
                                                  @Query("test_time") String test_time);
}
