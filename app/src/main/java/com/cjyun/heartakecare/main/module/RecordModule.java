package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.RecordFragment;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/7/27 0027
 * 描 述：TODO
 */
@Module
public class RecordModule extends BaseModule<RecordFragment> {
    public RecordModule(RecordFragment activity) {
        super(activity);
    }

    @Provides
    RecordFragment provideView(){
        return getView();
    }
}
