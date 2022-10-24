package com.spring.ioc.springBeanTest.lifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {

  public static void main(String[] args) {

    System.out.println("现在开始初始化容器");

    ApplicationContext factory = new ClassPathXmlApplicationContext("beanLifeCyclebeans.xml");
    System.out.println("容器初始化成功");
    // 得到Person，并使用
    Person person2 = factory.getBean("person2", Person.class);
    System.out.println(person2);

    System.out.println();
    Person person22 = factory.getBean("person2", Person.class);
    System.out.println(person22);

    System.out.println();
    Person person3 = factory.getBean("person3", Person.class);
    System.out.println(person3);

    System.out.println();
    Person person32 = factory.getBean("person3", Person.class);
    System.out.println(person32);

    System.out.println("\nSingleton ");
    System.out.println(person2 == person22);

    System.out.println("\nPrototype");
    System.out.println(person3 == person32);

    System.out.println("现在开始关闭容器！");
    ((ClassPathXmlApplicationContext) factory).registerShutdownHook();
  }
}