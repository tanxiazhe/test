package com.spring.ioc.springBeanTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeansInjection {

    private static ApplicationContext factory;

    public static void main(String[] args) {

        System.out.println("现在开始初始化容器");

        factory = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("容器初始化成功");

        SpringDao springDao = factory.getBean("springDao", SpringDao.class);
        springDao.ok();

        SpringAction4 springAction4 = factory.getBean("springAction4", SpringAction4.class);
        springAction4.factorySave();

        SpringAction3 springAction3 = factory.getBean("springAction3", SpringAction3.class);
        springAction3.staticFactorySave();

        SpringAction2 springAction2 = factory.getBean("springAction2", SpringAction2.class);
        springAction2.save();

        SpringAction springAction = factory.getBean("springAction", SpringAction.class);
        springAction.ok();
        //
        TestCollection collection = factory.getBean("testCollection", TestCollection.class);
        System.out.println(collection);

        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext) factory).registerShutdownHook();

    }
}