package com.spring.ioc.simple.ioc;

public class Application {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AbstractApplicationContext();
        context.setUpElements(new String[] { "beanlifeCyclebeans.xml" });
        context.getBean("person");
    }
}
