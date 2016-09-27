package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.CheckedFragment;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/7/27 0027
 * 描 述：TODO
 */
@Module
public class CheckedModule extends BaseModule<CheckedFragment>{
    public CheckedModule(CheckedFragment activity) {
        super(activity);
    }

    @Provides
    CheckedFragment provideView(){
        return getView();
    }
}
