package com.damiza.my.shop.commons.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 要求是单例
 */
public final class SpringContext {
    //使用恶汉式的单例
    public static ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");


}
