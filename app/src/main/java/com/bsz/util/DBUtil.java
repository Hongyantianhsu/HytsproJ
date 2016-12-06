package com.bsz.util;

import android.database.sqlite.SQLiteDatabase;

import com.bsz.dao.DaoMaster;
import com.bsz.dao.DaoSession;
import com.bsz.dao.DownInfo;
import com.bsz.dao.DownInfoDao;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * 数据库操作工具类
 * Created by sunyan on 16/12/6.
 */
public class DBUtil {
    private static final String DB_NAME = "green_db";
    private static DBUtil dbutil;
    private DaoMaster.DevOpenHelper openHelper;
    private DBUtil(){
        openHelper = new DaoMaster.DevOpenHelper(UIUtils.getContext(),DB_NAME,null);
    }

    public static DBUtil getInstance(){
        if (dbutil == null){
            synchronized (DBUtil.class){
                dbutil = new DBUtil();
            }
        }
        return dbutil;
    }

    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(UIUtils.getContext(), DB_NAME, null);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     * @return
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null){
            openHelper = new DaoMaster.DevOpenHelper(UIUtils.getContext(),DB_NAME,null);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }

    public void save(DownInfo info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        DownInfoDao downInfoDao = daoSession.getDownInfoDao();
        downInfoDao.insert(info);
    }

    public void update(DownInfo info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        DownInfoDao downInfoDao = daoSession.getDownInfoDao();
        downInfoDao.update(info);
    }

    public void deleteDowninfo(DownInfo info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        DownInfoDao downInfoDao = daoSession.getDownInfoDao();
        downInfoDao.delete(info);
    }


    public DownInfo queryDownBy(long Id) {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        DownInfoDao downInfoDao = daoSession.getDownInfoDao();
        QueryBuilder<DownInfo> qb = downInfoDao.queryBuilder();
        qb.where(DownInfoDao.Properties.Id.eq(Id));
        List<DownInfo> list = qb.list();
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
    }

    public List<DownInfo> queryDownAll() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        DownInfoDao downInfoDao = daoSession.getDownInfoDao();
        QueryBuilder<DownInfo> qb = downInfoDao.queryBuilder();
        return qb.list();
    }
}
