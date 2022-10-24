package com.spring.aop.usage.proxyFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.ioc.springBeanTest.User;

public class LoginServiceImplTest {
    private static ApplicationContext factory;

    public static void main(String[] args) {
        factory = new ClassPathXmlApplicationContext("applicationContext.xml");

        LoginService loginService = (LoginService) factory.getBean("loginServiceProxy");
        loginService.login(new User("xinchun.wang", "123456"));

    }
}