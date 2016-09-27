package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.CheckedObjectActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/8/5 0005
 * 描 述： TODO
 */
@Module
public class CheckedObjectModule extends BaseModule<CheckedObjectActivity> {

    public CheckedObjectModule(CheckedObjectActivity activity) {
        super(activity);
    }

    @Provides
    CheckedObjectActivity checkedObjectActivity() {
        return getView();
    }
}
