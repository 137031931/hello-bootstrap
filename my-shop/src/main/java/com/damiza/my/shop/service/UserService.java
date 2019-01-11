package com.damiza.my.shop.service;

import com.damiza.my.shop.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public User login(String email, String password);
}
