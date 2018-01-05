package com.duo.lijinduo.myapplication.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 版权：XXX公司 版权所有
 * 作者：lijinduo
 * 版本：2.0
 * 创建日期：2018/1/4
 * 描述：(重构)
 * 修订历史：
 * 参考链接：
 */
@Entity
public class User {
    @Id //标明主键，括号里可以指定是否自增
    private Long id;
    private String name;
    private int height;

    @Transient  //标识这个字段是自定义的不会创建到数据库表里 相当于2.2版本的
    private int tempUsageCount;
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getHeight() {
        return this.height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    @Generated(hash = 206519522)
    public User(Long id, String name, int height) {
        this.id = id;
        this.name = name;
        this.height = height;
    }
    @Generated(hash = 586692638)
    public User() {
    }




}
