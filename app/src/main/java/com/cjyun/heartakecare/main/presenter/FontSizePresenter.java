package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.main.ui.FontSizeActivity;
import com.cjyun.heartakecare.main.view.FontSizeView;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/8/9 0009
 * 描 述： TODO
 */
public class FontSizePresenter extends BasePresenter<FontSizeView> {

    private FontSizeActivity mActivity;

    @Inject
    public FontSizePresenter(FontSizeActivity activity) {
        mActivity = activity;
    }
}
