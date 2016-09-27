package com.cjyun.heartakecare.main.component;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.main.module.WLANSettingsModule;
import com.cjyun.heartakecare.main.ui.WLANSettingsActivity;
import com.cjyun.heartakecare.utils.scope.ActivityScope;

import dagger.Component;

/**
 * 创建者: vee
 * 时 间: 2016/8/11 0011
 * 描 述： TODO
 */
@ActivityScope
@Component(modules = WLANSettingsModule.class, dependencies = AppComponent.class)
public interface WLANSettingsComponent {

    void inject(WLANSettingsActivity activity);
}
