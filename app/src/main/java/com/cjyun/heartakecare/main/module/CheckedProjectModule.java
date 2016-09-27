package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.CheckedProjectActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/8/4 0004
 * 描 述： TODO
 */
@Module
public class CheckedProjectModule extends BaseModule<CheckedProjectActivity> {

    public CheckedProjectModule(CheckedProjectActivity activity) {
        super(activity);
    }

    @Provides
    CheckedProjectActivity provideActivity(){
        return getView();
    }
}
