package com.cjyun.heartakecare;

import android.os.Handler;

import com.cjyun.heartakecare.data.api.ApiServer;
import com.cjyun.heartakecare.data.api.module.ApiServerModule;
import com.cjyun.heartakecare.db.RecordDBDao;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 创建者: vee
 * 时 间: 2016/7/14 0014
 * 描 述：TODO
 */
@Singleton
@Component(modules = {AppModule.class, ApiServerModule.class})
public interface AppComponent {

    Handler getHandler();

    App getApp();

    ApiServer getApiServer();

    Gson getGson();

    //记录的数据库
    RecordDBDao getRecordDBDao();

}
