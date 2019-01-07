package com.damiza.hello.spring;

import com.damiza.hello.spring.service.UserService;
import com.damiza.hello.spring.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 这里将UserService的实例化交给了Spring容器,用getBean取出
 */
public class MyTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHi();
    }
}

