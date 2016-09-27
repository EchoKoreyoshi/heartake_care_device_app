package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.EquipmentAuthorizationActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/9/21 0021
 * 描 述： TODO
 */
@Module
public class EquipmentAuthorizationModule extends BaseModule<EquipmentAuthorizationActivity> {
    public EquipmentAuthorizationModule(EquipmentAuthorizationActivity activity) {
        super(activity);
    }

    @Provides
    EquipmentAuthorizationActivity provideEquipmentAuthorizationActivity(){
        return getView();
    }
}
