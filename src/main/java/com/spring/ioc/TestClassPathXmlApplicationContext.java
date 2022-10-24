package com.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestClassPathXmlApplicationContext {

    public static void main(String[] args) {
        System.out.println("现在开始初始化容器");
        @SuppressWarnings("resource")
        ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext2.xml");
        System.out.println("容器初始化成功");
        Pad p1 = factory.getBean("pad1", Pad.class);
        System.out.println(p1.getPrice());
        // 得到Person，并使用
        // Person person = beanfactory.getBean("person", Person.class);
        // System.out.println(person);
    }
}