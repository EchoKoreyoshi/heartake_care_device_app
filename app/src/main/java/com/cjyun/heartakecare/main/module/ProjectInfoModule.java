package com.cjyun.heartakecare.main.module;

import com.cjyun.heartakecare.base.module.BaseModule;
import com.cjyun.heartakecare.main.ui.ProjectInfoActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/8/4 0004
 * 描 述： TODO
 */
@Module
public class ProjectInfoModule extends BaseModule<ProjectInfoActivity> {

    public ProjectInfoModule(ProjectInfoActivity activity) {
        super(activity);
    }

    @Provides
    ProjectInfoActivity projectInfoActivity() {
        return getView();
    }
}
