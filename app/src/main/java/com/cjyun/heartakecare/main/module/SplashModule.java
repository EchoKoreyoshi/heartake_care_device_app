package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.SplashActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/7/14 0014
 * 描 述：TODO
 */
@Module
public class SplashModule extends BaseModule<SplashActivity>{

    public SplashModule(SplashActivity activity) {
        super(activity);
    }

    @Provides
    SplashActivity provideSplashActivity(){
        return getView();
    }
}
