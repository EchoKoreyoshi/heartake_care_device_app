package com.cjyun.heartakecare.data.api.module;

import com.cjyun.heartakecare.data.api.ApiServer;
import com.cjyun.heartakecare.utils.Constant;
import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 创建者: vee
 * 时 间: 2016/7/14 0014
 * 描 述： TODO
 */
@Module
public class ApiServerModule {

    public ApiServerModule() {
    }

    @Singleton
    @Provides
    Gson provideGson() {
        return new Gson();
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .connectTimeout(Constant.CONN_TIME, TimeUnit.MILLISECONDS)
                .readTimeout(Constant.READ_TIME, TimeUnit.MILLISECONDS)
                .writeTimeout(Constant.WRITE_TIME, TimeUnit.MILLISECONDS)
                .build();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(Gson gson, OkHttpClient client) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .client(client)
                .build();
    }

    @Singleton
    @Provides
    ApiServer provideApiServer(Retrofit retrofit) {
        return retrofit.create(ApiServer.class);
    }
}
