package com.cjyun.heartakecare.main.component;

import com.cjyun.heartakecare.AppComponent;
import com.cjyun.heartakecare.main.module.RecordModule;
import com.cjyun.heartakecare.main.ui.RecordFragment;
import com.cjyun.heartakecare.utils.scope.FragmentScope;

import dagger.Component;

/**
 * 创建者: vee
 * 时 间: 2016/7/27 0027
 * 描 述：TODO
 */
@FragmentScope
@Component(modules = RecordModule.class,dependencies = AppComponent.class)
public interface RecordComponent {
    void inject(RecordFragment fragment);
}
