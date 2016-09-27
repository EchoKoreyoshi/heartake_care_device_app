package com.cjyun.heartakecare.main.component;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.main.module.ProjectInfoModule;
import com.cjyun.heartakecare.main.ui.ProjectInfoActivity;
import com.cjyun.heartakecare.utils.scope.ActivityScope;

import dagger.Component;

/**
 * 创建者: vee
 * 时 间: 2016/8/4 0004
 * 描 述： TODO
 */
@ActivityScope
@Component(modules = ProjectInfoModule.class, dependencies = AppComponent.class)
public interface ProjectInfoComponent {
    void inject(ProjectInfoActivity activity);
}
