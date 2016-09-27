package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.SelectActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/7/18 0018
 * 描 述：TODO
 */
@Module
public class SelectModule extends BaseModule<SelectActivity>{

    public SelectModule(SelectActivity activity) {
        super(activity);
    }

    @Provides
    SelectActivity provideActivity(){
        return getView();
    }
}
