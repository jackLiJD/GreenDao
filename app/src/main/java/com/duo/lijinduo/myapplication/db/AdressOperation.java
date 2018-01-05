package com.duo.lijinduo.myapplication.db;

import android.util.Log;

import com.duo.lijinduo.myapplication.bean.Address;
import com.duo.lijinduo.myapplication.greendao.AddressDao;

import java.util.List;

/**
 * 版权：XXX公司 版权所有
 * 作者：lijinduo
 * 版本：2.0
 * 创建日期：2018/1/5
 * 描述：(重构)
 * 修订历史：
 * 参考链接：
 */
public class AdressOperation {
    private static AdressOperation adressOperation;

    private AddressDao addressDao = DaoManager.getInstance("AdressInfo").getSession().getAddressDao();

    public static AdressOperation getUserDao() {
        if (adressOperation == null) {
            adressOperation = new AdressOperation();
        }
        return adressOperation;
    }


    /**
     * 添加地址
     * id不能重复
     */
    public void insertAddress() {
        Address address = new Address(null, "黑龙江", "鸡西市");
        addressDao.insert(address);
        Address address1 = new Address(null, "浙江省", "杭州市");
        addressDao.insert(address1);
    }

    /**
     * 地址查询
     */
    public void queryAddress() {
        List<Address> addressList = addressDao.queryBuilder()
                .orderAsc(AddressDao.Properties.Id)
                .build().list();
        for (int i = 0; i < addressList.size(); i++) {
            Log.d("查询的数据", "query: " + addressList.get(i).getId() + "|" + addressList.get(i).getProvince() + "|" + addressList.get(i).getCity());
        }
    }

    /**
     * 清空数据库
     */
    public void clear() {
        addressDao.deleteAll();
    }


}
