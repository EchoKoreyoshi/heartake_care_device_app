package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.DevicesAuthorizeActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/8/6 0006
 * 描 述： TODO
 */
@Module
public class DevicesAuthorizeModule extends BaseModule<DevicesAuthorizeActivity> {

    public DevicesAuthorizeModule(DevicesAuthorizeActivity activity) {
        super(activity);
    }

    @Provides
    DevicesAuthorizeActivity devicesAuthorizeActivity() {
        return getView();
    }

    ;
}
