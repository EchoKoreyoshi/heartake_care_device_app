package com.cjyun.heartakecare.utils;

import android.content.Context;
import android.widget.Toast;

import com.cjyun.heartakecare.App;

/**
 * 创建者: vee
 * 时 间: 2016/9/2 0002
 * 描 述： Toast统一管理类
 */
public class ToastUtils {

    public static boolean isShow = true;

    private ToastUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    private static Context getContext() {
        return App.getContext();
    }

    /**
     * 显示消息体-->String类型
     *
     * @param message String类型的消息体
     */
    public static void showMessage(String message) {
        if (isShow) Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 自定义显示Toast时间
     *
     * @param message  引用String资源
     * @param duration Toast的时间
     */
    public static void show(int message, int duration) {
        if (isShow)
            Toast.makeText(getContext(), getContext().getResources().getString(message), duration).show();
    }

    /**
     * 默认短时间显示
     *
     * @param message 引用String资源
     */
    public static void showShort(int message) {
        if (isShow)
            Toast.makeText(getContext(), getContext().getResources().getString(message), Toast.LENGTH_SHORT).show();
    }

    /**
     * 默认长时间显示
     *
     * @param message 引用String资源
     */
    public static void showLong(int message) {
        if (isShow)
            Toast.makeText(getContext(), getContext().getResources().getString(message), Toast.LENGTH_LONG).show();
    }

}
