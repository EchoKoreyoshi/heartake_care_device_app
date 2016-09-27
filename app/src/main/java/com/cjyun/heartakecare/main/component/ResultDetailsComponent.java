package com.cjyun.heartakecare.main.component;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.main.module.ResultDetailsModule;
import com.cjyun.heartakecare.main.ui.ResultDetailsActivity;
import com.cjyun.heartakecare.utils.scope.ActivityScope;

import dagger.Component;

/**
 * 创建者: vee
 * 时 间: 2016/8/6 0006
 * 描 述： TODO
 */
@ActivityScope
@Component(modules = ResultDetailsModule.class,dependencies = AppComponent.class)
public interface ResultDetailsComponent {

    void inject(ResultDetailsActivity activity);
}
