package com.duo.lijinduo.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.duo.lijinduo.myapplication.greendao.AddressDao;
import com.duo.lijinduo.myapplication.greendao.DaoMaster;

import org.greenrobot.greendao.database.Database;

/**
 * 版权：XXX公司 版权所有
 * 作者：lijinduo
 * 版本：2.0
 * 创建日期：2018/1/5
 * 描述：(重构)
 * 修订历史：
 * 参考链接：
 */
public class MyOpenHelper extends DaoMaster.OpenHelper {

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    /**
     * 数据库升级
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        //操作数据库的更新 有几个表升级都可以传入到下面
        MigrationHelper.getInstance().migrate(db,AddressDao.class);
    }

}