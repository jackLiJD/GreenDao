package com.duo.lijinduo.myapplication.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 版权：XXX公司 版权所有
 * 作者：lijinduo
 * 版本：2.0
 * 创建日期：2018/1/5
 * 描述：(重构)
 * 修订历史：
 * 参考链接：
 */
@Entity
public class Address {
    @Id
    private Long Id;

    private String province;

    private String City;

    private String str;

    public String getCity() {
        return this.City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getProvince() {
        return this.province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Long getId() {
        return this.Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getStr() {
        return this.str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Generated(hash = 275067651)
    public Address(Long Id, String province, String City, String str) {
        this.Id = Id;
        this.province = province;
        this.City = City;
        this.str = str;
    }

    @Generated(hash = 388317431)
    public Address() {
    }





}
