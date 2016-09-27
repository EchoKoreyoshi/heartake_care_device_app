package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.AddCheckedObjectInfoActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/8/5 0005
 * 描 述： TODO
 */
@Module
public class AddCheckedObjectInfoModule extends BaseModule<AddCheckedObjectInfoActivity> {

    public AddCheckedObjectInfoModule(AddCheckedObjectInfoActivity activity) {
        super(activity);
    }

    @Provides
    AddCheckedObjectInfoActivity addCheckedObjectInfoActivity() {
        return getView();
    }
}
