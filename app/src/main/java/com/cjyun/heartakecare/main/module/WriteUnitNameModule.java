package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.WriteUnitNameActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/8/6 0006
 * 描 述： TODO
 */
@Module
public class WriteUnitNameModule extends BaseModule<WriteUnitNameActivity> {
    public WriteUnitNameModule(WriteUnitNameActivity activity) {
        super(activity);
    }

    @Provides
    WriteUnitNameActivity writeUnitNameActivity() {
        return getView();
    }
}
