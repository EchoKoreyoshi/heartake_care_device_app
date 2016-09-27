package com.cjyun.heartakecare.main.component;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.main.module.FontSizeModule;
import com.cjyun.heartakecare.main.ui.FontSizeActivity;
import com.cjyun.heartakecare.utils.scope.ActivityScope;

import dagger.Component;

/**
 * 创建者: vee
 * 时 间: 2016/8/9 0009
 * 描 述： TODO
 */
@ActivityScope
@Component(modules = FontSizeModule.class, dependencies = AppComponent.class)
public interface FontSizeComponent {
    void inject(FontSizeActivity activity);
}
