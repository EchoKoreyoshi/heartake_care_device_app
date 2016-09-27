package com.cjyun.heartakecare.main.component;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.main.module.CheckedObjectModule;
import com.cjyun.heartakecare.main.ui.CheckedObjectActivity;
import com.cjyun.heartakecare.utils.scope.ActivityScope;

import dagger.Component;

/**
 * 创建者: vee
 * 时 间: 2016/8/5 0005
 * 描 述： TODO
 */
@ActivityScope
@Component(modules = CheckedObjectModule.class, dependencies = AppComponent.class)
public interface CheckedObjectComponent {

    void inject(CheckedObjectActivity activity);
}
