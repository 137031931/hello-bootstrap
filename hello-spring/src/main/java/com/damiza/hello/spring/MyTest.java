package com.damiza.hello.spring;

import com.damiza.hello.spring.service.UserService;
import com.damiza.hello.spring.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 这里将UserService的实例化交给了Spring容器,用getBean取出
 */
public class MyTest {
    //恶汉式的单例模式
    private static final Logger logger =LoggerFactory.getLogger(MyTest.class);
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHi();
        logger.info("info级别的日志");
        logger.debug("debug级别的日志");
        logger.warn("warn级别的日志");
        logger.error("error级别的日志");
        String message1 = "测试1";
        String message2 = "测试2";
        //这种写法没有使用+号而是使用占位符{},节省了运行空间
        logger.info("message is: {} {}",message1,message2);
        //在字符串拼接的时候同样可以使用这种方法,但是要用format方法来实现
        System.out.println(String.format("message is :%s %s",message1,message2));
        //这种方式不推荐使用,和用加号差不多
        System.out.println(message1.concat(message2));
    }
}

