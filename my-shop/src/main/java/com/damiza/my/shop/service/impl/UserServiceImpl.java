package com.damiza.my.shop.service.impl;

import com.damiza.my.shop.commons.context.SpringContext;
import com.damiza.my.shop.dao.UserDao;
import com.damiza.my.shop.entity.User;
import com.damiza.my.shop.service.UserService;

public class UserServiceImpl implements UserService {

    public User login(String email, String password) {
        SpringContext context = new SpringContext();
        UserDao userDao = (UserDao) context.getBean("userDao");

        return userDao.getUser(email, password);

    }
}
