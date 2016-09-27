package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.LanguageSelectActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/8/9 0009
 * 描 述： TODO
 */
@Module
public class LanguageSelectModule extends BaseModule<LanguageSelectActivity>{

    public LanguageSelectModule(LanguageSelectActivity activity) {
        super(activity);
    }

    @Provides
    LanguageSelectActivity languageSelectActivity(){
        return getView();
    }
}
