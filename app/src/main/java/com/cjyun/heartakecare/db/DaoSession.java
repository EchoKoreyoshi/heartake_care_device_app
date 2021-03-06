package com.cjyun.heartakecare.db;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.cjyun.heartakecare.db.RecordDB;

import com.cjyun.heartakecare.db.RecordDBDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig recordDBDaoConfig;

    private final RecordDBDao recordDBDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        recordDBDaoConfig = daoConfigMap.get(RecordDBDao.class).clone();
        recordDBDaoConfig.initIdentityScope(type);

        recordDBDao = new RecordDBDao(recordDBDaoConfig, this);

        registerDao(RecordDB.class, recordDBDao);
    }
    
    public void clear() {
        recordDBDaoConfig.clearIdentityScope();
    }

    public RecordDBDao getRecordDBDao() {
        return recordDBDao;
    }

}
