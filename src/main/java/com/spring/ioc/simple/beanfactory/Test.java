package com.spring.ioc.simple.beanfactory;

public class Test {

    public static void main(String[] args) throws Exception {

        // 加载配置文件
        BeanFactory f = new ClassPathXmlApplicationContext("./myApplicationContext.xml");

        // 英格兰
        Object oe = f.getBean("E");
        Team e = (Team) oe;
        e.say();

        // 西班牙
        Object os = f.getBean("S");
        Team s = (Team) os;
        s.say();

        // 葡萄牙
        Object op = f.getBean("P");
        Team p = (Team) op;
        p.say();
    }

}