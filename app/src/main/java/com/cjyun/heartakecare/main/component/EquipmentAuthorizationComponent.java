package com.cjyun.heartakecare.main.component;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.base.component.BaseComponent;
import com.cjyun.heartakecare.main.module.EquipmentAuthorizationModule;
import com.cjyun.heartakecare.main.ui.EquipmentAuthorizationActivity;
import com.cjyun.heartakecare.utils.scope.ActivityScope;

import dagger.Component;

/**
 * 创建者: vee
 * 时 间: 2016/9/21 0021
 * 描 述： TODO
 */
@ActivityScope
@Component(modules = EquipmentAuthorizationModule.class, dependencies = AppComponent.class)
public interface EquipmentAuthorizationComponent extends BaseComponent<EquipmentAuthorizationActivity> {
}
