package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/7/20 0020
 * 描 述：这里面主要用来请求网络数据访问
 */
@Module
public class MainModule extends BaseModule<MainActivity> {

    public MainModule(MainActivity activity) {
        super(activity);
    }

    @Provides
    MainActivity provideMainActivity() {
        return getView();
    }
}
