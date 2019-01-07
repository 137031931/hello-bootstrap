package com.damiza.hello.spring.service.test;

import com.damiza.hello.spring.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceTest {
    private UserService userService;
    @Before
    public void bofore(){
        System.out.println("初始化数据库连接");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        userService = (UserService) applicationContext.getBean("userService");

    }

    @Test
    public void testSayHi(){
        userService.sayHi();
    }
    @After
    public void after(){
        System.out.println("关闭数据库连接");
    }
}
