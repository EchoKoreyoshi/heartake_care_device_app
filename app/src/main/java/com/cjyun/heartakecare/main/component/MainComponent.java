package com.cjyun.heartakecare.main.component;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.main.ui.MainActivity;
import com.cjyun.heartakecare.utils.scope.ActivityScope;
import com.cjyun.heartakecare.base.component.BaseComponent;
import com.cjyun.heartakecare.main.module.MainModule;

import dagger.Component;

/**
 * 创建者: vee
 * 时 间: 2016/7/20 0020
 * 描 述： TODO
 */
@ActivityScope
@Component(modules = MainModule.class,dependencies = AppComponent.class)
public interface MainComponent extends BaseComponent<MainActivity>{
}
