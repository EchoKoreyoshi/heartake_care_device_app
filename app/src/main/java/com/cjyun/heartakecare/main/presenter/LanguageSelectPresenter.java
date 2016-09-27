package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.main.ui.LanguageSelectActivity;
import com.cjyun.heartakecare.main.view.LanguageSelectView;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/8/9 0009
 * 描 述： TODO
 */
public class LanguageSelectPresenter extends BasePresenter<LanguageSelectView> {

    private LanguageSelectActivity mActivity;

    @Inject
    public LanguageSelectPresenter(LanguageSelectActivity activity){
        mActivity = activity;
    }
}
