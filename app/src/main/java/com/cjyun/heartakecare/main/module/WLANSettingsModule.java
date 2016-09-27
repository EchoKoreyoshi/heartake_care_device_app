package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.WLANSettingsActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/8/11 0011
 * 描 述： TODO
 */
@Module
public class WLANSettingsModule extends BaseModule<WLANSettingsActivity> {

    public WLANSettingsModule(WLANSettingsActivity activity) {
        super(activity);
    }

    @Provides
    WLANSettingsActivity wlamSettingsActivity() {
        return getView();
    }
}
