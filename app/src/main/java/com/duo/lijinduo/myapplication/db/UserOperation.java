package com.duo.lijinduo.myapplication.db;

import android.util.Log;
import com.duo.lijinduo.myapplication.bean.User;
import com.duo.lijinduo.myapplication.greendao.UserDao;

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
public class UserOperation {
    private static UserOperation userOperation;

    private UserDao userDao = DaoManager.getInstance("UserInfo").getSession().getUserDao();

    public static UserOperation getUserDao(){
        if (userOperation == null) {
            userOperation = new UserOperation();
        }
        return userOperation;
    }

    /**
     * id查询
     */
    public void query() {
        //不为1 且数据长度等于5(只取5条)
        //where 条件
        //noEq 排除
        List<User> userList = userDao.queryBuilder()
                .where(UserDao.Properties.Id.notEq(1))
                .limit(5)
                .build().list();
        for (int i = 0; i < userList.size(); i++) {
            Log.d("查询的数据", "query: " + userList.get(i).getId() + "|" + userList.get(i).getName() + "|" + userList.get(i).getHeight());
        }
    }
    /**
     * 身高倒叙查询
     */
    public void queryAgeFlashback() {
        //orderDesc 所查询结果倒序
        //orderAsc 所查询结果正序
        //先正序查询身高 如果相同倒序查询主Id
        List<User> userList = userDao.queryBuilder()
                .orderAsc(UserDao.Properties.Height)
                .orderDesc(UserDao.Properties.Id)
                .build().list();
        for (int i = 0; i < userList.size(); i++) {
            Log.d("查询的数据", "query: " + userList.get(i).getId() + "|" + userList.get(i).getName() + "|" + userList.get(i).getHeight());
        }
    }

    /**
     *从数据库中删除说有王昭君的数据
     * (唯一参数那种 userid或者身份证号)
     * 不可重复
     */
    public void clearWangZhaoJun(){
        User findUser = userDao.queryBuilder().where(UserDao.Properties.Name.eq("王昭君")).build().unique();
        if(findUser != null){
            userDao.deleteByKey(findUser.getId());
        }
    }


    /**
     * 按照Id正序查询
     */
    public void queryById(){
        List<User> userList = userDao.queryBuilder()
                .orderAsc(UserDao.Properties.Id)
                .build().list();
        for (int i = 0; i < userList.size(); i++) {
            Log.d("查询的数据", "query: " + userList.get(i).getId() + "|" + userList.get(i).getName() + "|" + userList.get(i).getHeight());
        }
    }


    /**
     * 清除表中所有诸葛亮
     */
    public void clearZhuGeLiangList(String str){
        List<User> userList = userDao.queryBuilder()
                .where(UserDao.Properties.Name.eq(str))
                .build().list();
        if (userList.size()== 0) {
            return;
        }
        for (int i = 0; i < userList.size(); i++) {
            User user=userList.get(i);
            userDao.deleteByKey(user.getId());
        }
    }
    public void insert() {
        User user1 = new User(null, "zhangsan", 180);
        userDao.insert(user1);
        User user2 = new User(null, "lisi", 165);
        userDao.insert(user2);
        User user3 = new User(null, "wangwu", 195);
        userDao.insert(user3);
        User user4 = new User(null, "wangwu", 165);
        userDao.insert(user4);
        User user5 = new User(null, "ak47", 160);
        userDao.insert(user5);
        User user6 = new User(null, "m4", 170);
        userDao.insert(user6);
        User user7 = new User(null, "诸葛亮", 175);
        userDao.insert(user7);
        User user8 = new User(null, "王昭君", 158);
        userDao.insert(user8);
        User user9 = new User(null, null, 0);
        userDao.insert(user9);
        User user10 = new User(null, "wangwu", 165);
        userDao.insert(user10);
    }

    /**
     * @param str
     * 修改名字等于xxx的函数
     */
    public void upDateAk47(String ordStr,String newStr){
        List<User> userList = userDao.queryBuilder()
                .where(UserDao.Properties.Name.eq(ordStr))
                .build().list();
        if (userList.size()== 0) {
            return;
        }
        for (int i = 0; i < userList.size(); i++) {
            User user=userList.get(i);
            user.setName(newStr);
            userDao.update(user);
        }
    }

    /**
     * 清空数据库
     */
    public void clear(){
        userDao.deleteAll();
    }






}
