package com.cjyun.heartakecare.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import com.cjyun.heartakecare.App;

import java.util.Locale;

/**
 * 创建者: vee
 * 时 间: 2016/8/31 0031
 * 描 述： 语言工具类
 */
public class LanguageUtil {
    /**
     * 设置语言
     *
     * @param language "cn" = 中文, "en" = 英文
     */
    public static void setLanguage(Context context, String language) {
        Resources resources = App.getApp(context).getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = new Locale(language);
        resources.updateConfiguration(configuration, null);

        saveLanguage(context, language);
    }

    public static void saveLanguage(Context context, String language) {
        SharedPreferencesUtils.setString(context, "language", language);
    }

    public static String getSavedLanguage(Context context) {
        return SharedPreferencesUtils.getString(context, "language", "");
    }
}
