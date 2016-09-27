package com.cjyun.heartakecare.main.presenter;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.base.listener.OnLoadDataListener;
import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.bean.AuthenticationTokenBean;
import com.cjyun.heartakecare.bean.EquipmentAuthorizationV1Bean;
import com.cjyun.heartakecare.bean.EquipmentAuthorizationV2Bean;
import com.cjyun.heartakecare.bean.EquipmentAuthorizationV3Bean;
import com.cjyun.heartakecare.bean.RefreshTokenBean;
import com.cjyun.heartakecare.main.model.EquipmentAuthorizationModel;
import com.cjyun.heartakecare.main.ui.EquipmentAuthorizationActivity;
import com.cjyun.heartakecare.main.view.EquipmentAuthorizationView;
import com.cjyun.heartakecare.utils.ToastUtils;
import com.socks.library.KLog;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/9/21 0021
 * 描 述： TODO
 */
public class EquipmentAuthorizationPresenter extends BasePresenter<EquipmentAuthorizationView> {
    @Inject
    EquipmentAuthorizationModel mModel;

    @Inject
    EquipmentAuthorizationActivity mActivity;

    @Inject
    public EquipmentAuthorizationPresenter() {
    }

    /**
     * 第一步
     */
    public void getAuthorizationkensV1() {
        mModel.AuthorizationkensV1(App.getContext(), new OnLoadDataListener<EquipmentAuthorizationV1Bean>() {
            @Override
            public void onSuccess(EquipmentAuthorizationV1Bean data) {
                String message = data.getMessage();
                KLog.e("成功返回：" + message);
                mActivity.setMtag(1);
            }

            @Override
            public void onFailed(String errorMsg) {
                ToastUtils.showMessage(errorMsg);
                KLog.e(errorMsg);
            }
        });
    }

    /**
     * 第二步
     */
    public void getAuthorizationkensV2() {
        mModel.AuthorizationkensV2(App.getContext(), new OnLoadDataListener<EquipmentAuthorizationV2Bean>() {
            @Override
            public void onSuccess(EquipmentAuthorizationV2Bean data) {
                String code = data.getCode();
                KLog.e("返回的code:" + code);
                mActivity.setMtag(2);
            }

            @Override
            public void onFailed(String errorMsg) {
                KLog.e("错误信息：" + errorMsg);
            }
        });
    }

    /**
     * 第三步
     */
    public void getAuthorizationkensV3() {
        mModel.AuthorizationkensV3(App.getContext(), new OnLoadDataListener<EquipmentAuthorizationV3Bean>() {
            @Override
            public void onSuccess(EquipmentAuthorizationV3Bean data) {
                String refresh_token = data.getRefresh_token();
                String access_token = data.getAccess_token();
                KLog.e("refresh_token:" + refresh_token + "  access_token:" + access_token);
                mActivity.setMtag(3);
            }

            @Override
            public void onFailed(String errorMsg) {
                KLog.e("errorMsg:" + errorMsg);
            }
        });
    }

    /**
     * 验证token
     */
    public void goToAuthenticationToken() {
        mModel.authenticationToken(App.getContext(), new OnLoadDataListener<AuthenticationTokenBean>() {
            @Override
            public void onSuccess(AuthenticationTokenBean data) {
                String status = data.getStatus();
                KLog.e("status:" + status);
                mActivity.setMtag(4);
            }

            @Override
            public void onFailed(String errorMsg) {
                KLog.e(errorMsg);
                getRefreshToken();
            }
        });
    }

    /**
     * 刷新token
     */
    public void getRefreshToken() {
        mModel.refreshedToken(App.getContext(), new OnLoadDataListener<RefreshTokenBean>() {
            @Override
            public void onSuccess(RefreshTokenBean data) {
                String access_token = data.getAccess_token();
                KLog.e("access_token:" + access_token);
            }

            @Override
            public void onFailed(String errorMsg) {
                KLog.e("errorMsg:" + errorMsg);
            }
        });
    }
}
