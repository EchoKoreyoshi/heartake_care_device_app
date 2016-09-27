package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.AboutUsActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/8/8 0008
 * 描 述： TODO
 */
@Module
public class AboutUsModule extends BaseModule<AboutUsActivity> {

    public AboutUsModule(AboutUsActivity activity) {
        super(activity);
    }

    @Provides
    AboutUsActivity aboutUsActivity() {
        return getView();
    }
}
