package com.cjyun.heartakecare.main.component;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.main.module.CheckedProjectModule;
import com.cjyun.heartakecare.main.ui.CheckedProjectActivity;
import com.cjyun.heartakecare.utils.scope.ActivityScope;

import dagger.Component;

/**
 * 创建者: vee
 * 时 间: 2016/8/4 0004
 * 描 述： TODO
 */
@ActivityScope
@Component(modules = CheckedProjectModule.class, dependencies = AppComponent.class)
public interface CheckedProjectComponent {

    void inject(CheckedProjectActivity activity);
}
