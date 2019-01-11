package com.damiza.my.shop.dao.impl;

import com.damiza.my.shop.dao.UserDao;
import com.damiza.my.shop.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
    /**
     * 验证登录在其中加入日志信息,这种方式叫做埋点
     */
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
    public User getUser(String email, String password) {
        logger.debug("调用getUser(),email:{} password:{}",email,password);
        User user = null;
        if("admin@qq.com".equals(email)){
            if("123456".equals(password)){
                user = new User();
                user.setEmail("admin@qq.com");
                user.setUsername("大米");
                logger.info("成功获取\"{}\"的用户信息",user.getUsername());
            }
        }else{
            logger.warn("获取\"{}\"的用户信息失败",email);
        }
       return user;
    }
}
