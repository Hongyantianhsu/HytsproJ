package com.bsz.util;

import android.database.sqlite.SQLiteDatabase;

import com.bsz.dao.DaoMaster;
import com.bsz.dao.DaoSession;
import com.bsz.dao.SaveInfo;
import com.bsz.dao.SaveInfoDao;

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

    public void save(SaveInfo info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        SaveInfoDao downInfoDao = daoSession.getSaveInfoDao();
        downInfoDao.insert(info);
    }

    public void update(SaveInfo info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        SaveInfoDao downInfoDao = daoSession.getSaveInfoDao();
        downInfoDao.update(info);
    }

    public void deleteDowninfo(SaveInfo info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        SaveInfoDao downInfoDao = daoSession.getSaveInfoDao();
        downInfoDao.delete(info);
    }


    public SaveInfo queryDownBy(long Id) {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        SaveInfoDao downInfoDao = daoSession.getSaveInfoDao();
        QueryBuilder<SaveInfo> qb = downInfoDao.queryBuilder();
        qb.where(SaveInfoDao.Properties.Id.eq(Id));
        List<SaveInfo> list = qb.list();
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
    }

    public List<SaveInfo> queryDownAll() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        SaveInfoDao downInfoDao = daoSession.getSaveInfoDao();
        QueryBuilder<SaveInfo> qb = downInfoDao.queryBuilder();
        return qb.list();
    }
}
