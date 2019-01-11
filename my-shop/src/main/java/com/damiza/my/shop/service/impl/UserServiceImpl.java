package com.damiza.my.shop.service.impl;

import com.damiza.my.shop.commons.context.SpringContext;
import com.damiza.my.shop.dao.UserDao;
import com.damiza.my.shop.entity.User;
import com.damiza.my.shop.service.UserService;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    private UserDao userDao = SpringContext.getBean("userDao");
    public User login(String email,String password) {
        return userDao.getUser(email,password);
    }
}
