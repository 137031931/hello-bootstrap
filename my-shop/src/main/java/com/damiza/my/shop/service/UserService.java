package com.damiza.my.shop.service;

import com.damiza.my.shop.entity.User;

public interface UserService {
    public User login(String email,String password);
}
