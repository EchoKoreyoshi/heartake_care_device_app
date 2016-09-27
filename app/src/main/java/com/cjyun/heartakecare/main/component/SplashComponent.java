package com.cjyun.heartakecare.main.component;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.main.ui.SplashActivity;
import com.cjyun.heartakecare.utils.scope.ActivityScope;
import com.cjyun.heartakecare.base.component.BaseComponent;
import com.cjyun.heartakecare.main.module.SplashModule;

import dagger.Component;

/**
 * 创建者: vee
 * 时 间: 2016/7/14 0014
 * 描 述：TODO
 */
@ActivityScope
@Component(modules = SplashModule.class, dependencies = AppComponent.class)
public interface SplashComponent extends BaseComponent<SplashActivity>{
}
