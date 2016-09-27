package com.cjyun.heartakecare;

import android.os.Handler;

import com.cjyun.heartakecare.db.DaoMaster;
import com.cjyun.heartakecare.db.DaoSession;
import com.cjyun.heartakecare.db.RecordDBDao;

import dagger.Module;
import dagger.Provides;

/**
 * 创建者: vee
 * 时 间: 2016/7/14 0014
 * 描 述：TODO
 */
@Module
public class AppModule {
    private App mApp;

    public AppModule(App app) {
        mApp = app;
    }

    @Provides
    App provideApp(){
        return mApp;
    }

    @Provides
    Handler provideHandler(){
        return new Handler();
    }

    @Provides
    RecordDBDao provideRecordDBDao(App app){
        //初始化数据库
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(app,"record_db",null);
        DaoMaster master = new DaoMaster(helper.getWritableDb());
        DaoSession session = master.newSession();
        return session.getRecordDBDao();
    }
}
