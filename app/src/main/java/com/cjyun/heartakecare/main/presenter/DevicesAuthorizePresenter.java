package com.cjyun.heartakecare.main.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjyun.heartakecare.App;
import com.cjyun.heartakecare.R;
import com.cjyun.heartakecare.base.listener.OnLoadDataListener;
import com.cjyun.heartakecare.base.presenter.BasePresenter;
import com.cjyun.heartakecare.bean.HomeAuthenticationBean;
import com.cjyun.heartakecare.bean.HomeAuthorizeToAppBean;
import com.cjyun.heartakecare.main.model.DevicesAuthorizeModel;
import com.cjyun.heartakecare.main.ui.DevicesAuthorizeActivity;
import com.cjyun.heartakecare.main.view.DevicesAuthorizeView;
import com.cjyun.heartakecare.qrcode.encoding.EncodingHandler;
import com.cjyun.heartakecare.utils.SharedPreferencesUtils;
import com.cjyun.heartakecare.utils.ToastUtils;
import com.socks.library.KLog;

import java.util.List;

import javax.inject.Inject;

/**
 * 创建者: vee
 * 时 间: 2016/8/6 0006
 * 描 述： TODO
 */
public class DevicesAuthorizePresenter extends BasePresenter<DevicesAuthorizeView> {
    @Inject
    DevicesAuthorizeModel mModel;

    private DevicesAuthorizeActivity mActivity;

    @Inject
    public DevicesAuthorizePresenter(DevicesAuthorizeActivity activity) {
        mActivity = activity;
    }

    /**
     * 生成二维码
     */
    public void createQRcode() {
        try {
            String device_id = SharedPreferencesUtils.getString(mActivity.getApplicationContext(), "device_id", "");
            Bitmap bitmap = BitmapFactory.decodeResource(mActivity.getResources(), R.mipmap.table_logo);
            Bitmap qrcodeImg = EncodingHandler.createQRCode(device_id, 800, 800, bitmap);
            ImageView mIvCode = (ImageView) mActivity.findViewById(R.id.iv_code);
            TextView mId = (TextView) mActivity.findViewById(R.id.id);
            mIvCode.setImageBitmap(qrcodeImg);
            mId.setText("ID:" + device_id);
            KLog.e("二维码生成成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 家庭用户授权一览
     */
    public void homeUserAuthentication() {
        mModel.homeAuthentication(App.getContext(), new OnLoadDataListener<HomeAuthenticationBean>() {
            @Override
            public void onSuccess(HomeAuthenticationBean data) {
                List<HomeAuthenticationBean.AuthListBean> auth_list = data.getAuth_list();
                List<HomeAuthenticationBean.UserListBean> user_list = data.getUser_list();
                if (auth_list.size() == 0 && user_list.size() == 0) {
                    KLog.e("----空状态----已成功执行-------");

                } else {
                    int user_id = auth_list.get(0).getUser_id();
                    String phone_number = user_list.get(0).getPhone_number();
                    String email = user_list.get(0).getEmail();
                    KLog.e("user_id:" + user_id + "  phone_number:" + phone_number + "  email:" + email);
                    mActivity.setTag(false);
//                    mActivity.showDialog(phone_number.isEmpty() ? email : phone_number);
                    if (TextUtils.isEmpty(phone_number))
                        mActivity.showDialog(email);
                    mActivity.showDialog(phone_number);
                }
            }

            @Override
            public void onFailed(String errorMsg) {
                KLog.e(errorMsg);
            }
        });
    }

    /**
     * 家庭版授权给App
     */
    public void homeAuthorize2App() {
        mModel.homeAuthorizeToApp(App.getContext(), new OnLoadDataListener<HomeAuthorizeToAppBean>() {
            @Override
            public void onSuccess(HomeAuthorizeToAppBean data) {
                String status = data.getStatus();
                KLog.e("授权：" + status);
                ToastUtils.showMessage("授权成功！");
            }

            @Override
            public void onFailed(String errorMsg) {
                KLog.e(errorMsg);
            }
        });
    }
}
