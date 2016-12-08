package com.bsz.rx_retrofit.http.dbutil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.bsz.dao.CookieInfo;
import com.bsz.dao.CookieInfoDao;
import com.bsz.dao.DaoMaster;
import com.bsz.dao.DaoSession;
import com.bsz.util.UIUtils;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

/**
 * 数据缓存
 * 数据库工具类-geendao运用
 * Created by sunyan on 2016/12/7.
 */

public class CookieDbUtil {
    private static CookieDbUtil db;
    private final static String dbName = "tests_db";
    private DaoMaster.DevOpenHelper openHelper;
    private Context context;


    public CookieDbUtil() {
        context= UIUtils.getContext();
        openHelper = new DaoMaster.DevOpenHelper(context, dbName);
    }


    /**
     * 获取单例
     * @return
     */
    public static CookieDbUtil getInstance() {
        if (db == null) {
            synchronized (CookieDbUtil.class) {
                if (db == null) {
                    db = new CookieDbUtil();
                }
            }
        }
        return db;
    }


    /**
     * 获取可读数据库
     */
    private SQLiteDatabase getReadableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName);
        }
        SQLiteDatabase db = openHelper.getReadableDatabase();
        return db;
    }

    /**
     * 获取可写数据库
     */
    private SQLiteDatabase getWritableDatabase() {
        if (openHelper == null) {
            openHelper = new DaoMaster.DevOpenHelper(context, dbName);
        }
        SQLiteDatabase db = openHelper.getWritableDatabase();
        return db;
    }


    public void saveCookie(CookieInfo info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        CookieInfoDao downInfoDao = daoSession.getCookieInfoDao();
        downInfoDao.insert(info);
    }

    public void updateCookie(CookieInfo info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        CookieInfoDao downInfoDao = daoSession.getCookieInfoDao();
        downInfoDao.update(info);
    }

    public void deleteCookie(CookieInfo info){
        DaoMaster daoMaster = new DaoMaster(getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        CookieInfoDao downInfoDao = daoSession.getCookieInfoDao();
        downInfoDao.delete(info);
    }


    public CookieInfo queryCookieBy(String  url) {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        CookieInfoDao downInfoDao = daoSession.getCookieInfoDao();
        QueryBuilder<CookieInfo> qb = downInfoDao.queryBuilder();
        qb.where(CookieInfoDao.Properties.Url.eq(url));
        List<CookieInfo> list = qb.list();
        if(list.isEmpty()){
            return null;
        }else{
            return list.get(0);
        }
    }

    public List<CookieInfo> queryCookieAll() {
        DaoMaster daoMaster = new DaoMaster(getReadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        CookieInfoDao downInfoDao = daoSession.getCookieInfoDao();
        QueryBuilder<CookieInfo> qb = downInfoDao.queryBuilder();
        return qb.list();
    }
}
