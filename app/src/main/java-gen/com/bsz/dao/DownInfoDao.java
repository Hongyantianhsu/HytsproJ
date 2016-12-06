package com.bsz.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DOWN_INFO".
*/
public class DownInfoDao extends AbstractDao<DownInfo, Long> {

    public static final String TABLENAME = "DOWN_INFO";

    /**
     * Properties of entity DownInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property SavePath = new Property(1, String.class, "savePath", false, "SAVE_PATH");
        public final static Property CountLength = new Property(2, long.class, "countLength", false, "COUNT_LENGTH");
        public final static Property ReadLength = new Property(3, long.class, "readLength", false, "READ_LENGTH");
        public final static Property StateInte = new Property(4, int.class, "stateInte", false, "STATE_INTE");
        public final static Property Url = new Property(5, String.class, "url", false, "URL");
    }


    public DownInfoDao(DaoConfig config) {
        super(config);
    }
    
    public DownInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DOWN_INFO\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"SAVE_PATH\" TEXT NOT NULL ," + // 1: savePath
                "\"COUNT_LENGTH\" INTEGER NOT NULL ," + // 2: countLength
                "\"READ_LENGTH\" INTEGER NOT NULL ," + // 3: readLength
                "\"STATE_INTE\" INTEGER NOT NULL ," + // 4: stateInte
                "\"URL\" TEXT NOT NULL );"); // 5: url
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DOWN_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DownInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getSavePath());
        stmt.bindLong(3, entity.getCountLength());
        stmt.bindLong(4, entity.getReadLength());
        stmt.bindLong(5, entity.getStateInte());
        stmt.bindString(6, entity.getUrl());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DownInfo entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getSavePath());
        stmt.bindLong(3, entity.getCountLength());
        stmt.bindLong(4, entity.getReadLength());
        stmt.bindLong(5, entity.getStateInte());
        stmt.bindString(6, entity.getUrl());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DownInfo readEntity(Cursor cursor, int offset) {
        DownInfo entity = new DownInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // savePath
            cursor.getLong(offset + 2), // countLength
            cursor.getLong(offset + 3), // readLength
            cursor.getInt(offset + 4), // stateInte
            cursor.getString(offset + 5) // url
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DownInfo entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSavePath(cursor.getString(offset + 1));
        entity.setCountLength(cursor.getLong(offset + 2));
        entity.setReadLength(cursor.getLong(offset + 3));
        entity.setStateInte(cursor.getInt(offset + 4));
        entity.setUrl(cursor.getString(offset + 5));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DownInfo entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DownInfo entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DownInfo entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
