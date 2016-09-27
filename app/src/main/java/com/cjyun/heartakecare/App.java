package com.cjyun.heartakecare;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.text.format.DateFormat;

import com.cjyun.heartakecare.main.ui.SplashActivity;
import com.cjyun.heartakecare.utils.LanguageUtil;
import com.lenwotion.power.PowerOperate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 创建者: vee
 * 时 间: 2016/7/14 0014
 * 描 述：程序入口
 */
public class App extends Application {
    private static App instance;
    private AppComponent mAppComponent;
    public static PowerOperate powerOperate = new PowerOperate();//io口

    public static App getInstance() {
        return instance;
    }

    public static App getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();


        //打开IO口
        powerOperate.mtSetGPIOValue(43, true);
        powerOperate.mtSetGPIOValue(8,true);
        powerOperate.mtSetGPIOValue(12,true);
        powerOperate.mtSetGPIOValue(13,true);



        instance = this;
        String savedLanguage = LanguageUtil.getSavedLanguage(this);
        if (TextUtils.isEmpty(savedLanguage)) {
            //设置默认的语言为"cn"
            LanguageUtil.setLanguage(this, "cn");
        } else {
            LanguageUtil.setLanguage(this, savedLanguage);
        }
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static App getApp(Context context) {
        return (App) context.getApplicationContext();
    }





    public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread thread, Throwable ex) {
            // context = this;
            try {
                CharSequence timestamp = DateFormat.format("yyyyMMdd_kkmmss",
                        System.currentTimeMillis());
                String filename = "error" + "_" + timestamp + ".log";
                File fileError = new File(Environment
                        .getExternalStorageDirectory().getPath() + "/error");
                if (!fileError.exists()) {
                    fileError.mkdir();
                }
                File file = new File(fileError, filename);

                FileOutputStream out = new FileOutputStream(file);
                PrintStream err = new PrintStream(out);
                ex.printStackTrace(err);
                out.close();

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                Intent intent = new Intent(getApplicationContext(),
                        SplashActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        }
    }
}
