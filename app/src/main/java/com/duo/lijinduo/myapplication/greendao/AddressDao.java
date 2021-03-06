package com.duo.lijinduo.myapplication.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.duo.lijinduo.myapplication.bean.Address;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ADDRESS".
*/
public class AddressDao extends AbstractDao<Address, Long> {

    public static final String TABLENAME = "ADDRESS";

    /**
     * Properties of entity Address.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "Id", true, "_id");
        public final static Property Province = new Property(1, String.class, "province", false, "PROVINCE");
        public final static Property City = new Property(2, String.class, "City", false, "CITY");
        public final static Property Str = new Property(3, String.class, "str", false, "STR");
    };


    public AddressDao(DaoConfig config) {
        super(config);
    }
    
    public AddressDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ADDRESS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: Id
                "\"PROVINCE\" TEXT," + // 1: province
                "\"CITY\" TEXT," + // 2: City
                "\"STR\" TEXT);"); // 3: str
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ADDRESS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Address entity) {
        stmt.clearBindings();
 
        Long Id = entity.getId();
        if (Id != null) {
            stmt.bindLong(1, Id);
        }
 
        String province = entity.getProvince();
        if (province != null) {
            stmt.bindString(2, province);
        }
 
        String City = entity.getCity();
        if (City != null) {
            stmt.bindString(3, City);
        }
 
        String str = entity.getStr();
        if (str != null) {
            stmt.bindString(4, str);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Address entity) {
        stmt.clearBindings();
 
        Long Id = entity.getId();
        if (Id != null) {
            stmt.bindLong(1, Id);
        }
 
        String province = entity.getProvince();
        if (province != null) {
            stmt.bindString(2, province);
        }
 
        String City = entity.getCity();
        if (City != null) {
            stmt.bindString(3, City);
        }
 
        String str = entity.getStr();
        if (str != null) {
            stmt.bindString(4, str);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Address readEntity(Cursor cursor, int offset) {
        Address entity = new Address( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // Id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // province
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // City
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // str
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Address entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setProvince(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCity(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setStr(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Address entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Address entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
