package com.cjyun.heartakecare.main.component;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.main.ui.SelectActivity;
import com.cjyun.heartakecare.utils.scope.ActivityScope;
import com.cjyun.heartakecare.base.component.BaseComponent;
import com.cjyun.heartakecare.main.module.SelectModule;

import dagger.Component;

/**
 * 创建者: vee
 * 时 间: 2016/7/18 0018
 * 描 述：TODO
 */
@ActivityScope
@Component(modules = SelectModule.class,dependencies = AppComponent.class)
public interface SelectComponent extends BaseComponent<SelectActivity>{
}
