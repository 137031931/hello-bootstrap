package com.damiza.my.shop.dao.impl;

import com.damiza.my.shop.dao.UserDao;
import com.damiza.my.shop.entity.User;

public class UserDaoImpl implements UserDao {
    public User getUser(String email, String password) {
        User user = null;
        if("admin@qq.com".equals(email)){
            if("123456".equals(password)){
                user = new User();
                user.setEmail("admin@qq.com");
                user.setUsername("大米");
            }
        }
       return user;
    }
}
