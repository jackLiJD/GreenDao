package com.duo.lijinduo.myapplication.db;

/**
 * 版权：XXX公司 版权所有
 * 作者：lijinduo
 * 版本：2.0
 * 创建日期：2018/1/4
 * 描述：(重构)
 * 修订历史：
 * 参考链接：
 */

import com.duo.lijinduo.myapplication.MyApplication;
import com.duo.lijinduo.myapplication.greendao.DaoMaster;
import com.duo.lijinduo.myapplication.greendao.DaoSession;

/**
 *  greenDao管理类
 */
public class DaoManager {
    private static DaoManager mInstance;
    private DaoSession mDaoSession;

    private DaoManager(String database) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getContext(), database, null);
        DaoMaster mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getSession() {
        return mDaoSession;
    }

    public static DaoManager getInstance(String str) {
        if (mInstance == null) {
            mInstance = new DaoManager(str);
        }
        return mInstance;
    }
}