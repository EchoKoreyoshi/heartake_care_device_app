package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.SettingsActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/8/6 0006
 * 描 述： TODO
 */
@Module
public class SettingsModule extends BaseModule<SettingsActivity> {

    public SettingsModule(SettingsActivity activity) {
        super(activity);
    }

    @Provides
    SettingsActivity settingsActivity() {
        return getView();
    }
}
