package com.cjyun.heartakecare.main.component;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.main.module.ScanCodeModule;
import com.cjyun.heartakecare.main.ui.ScanCodeActivity;
import com.cjyun.heartakecare.utils.scope.ActivityScope;

import dagger.Component;

/**
 * 创建者: vee
 * 时 间: 2016/8/5 0005
 * 描 述： TODO
 */
@ActivityScope
@Component(modules = ScanCodeModule.class, dependencies = AppComponent.class)
public interface ScanCodeComponent {
    void inject(ScanCodeActivity activity);
}
