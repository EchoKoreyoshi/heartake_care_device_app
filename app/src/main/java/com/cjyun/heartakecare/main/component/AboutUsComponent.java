package com.cjyun.heartakecare.main.component;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.main.module.AboutUsModule;
import com.cjyun.heartakecare.main.ui.AboutUsActivity;
import com.cjyun.heartakecare.utils.scope.ActivityScope;

import dagger.Component;

/**
 * 创建者: vee
 * 时 间: 2016/8/8 0008
 * 描 述： TODO
 */
@ActivityScope
@Component(modules = AboutUsModule.class, dependencies = AppComponent.class)
public interface AboutUsComponent {

    void inject(AboutUsActivity activity);
}
