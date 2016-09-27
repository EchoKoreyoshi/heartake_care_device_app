package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.ScanCodeActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/8/5 0005
 * 描 述： TODO
 */
@Module
public class ScanCodeModule extends BaseModule<ScanCodeActivity> {

    public ScanCodeModule(ScanCodeActivity activity) {
        super(activity);
    }

    @Provides
    ScanCodeActivity scanCodeActivity(){
       return getView();
    }
}
