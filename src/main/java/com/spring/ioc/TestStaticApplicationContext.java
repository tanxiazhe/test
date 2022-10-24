package com.spring.ioc;

import org.springframework.context.support.StaticApplicationContext;

public class TestStaticApplicationContext {

    public static void main(String[] args) {
        StaticApplicationContext applicationContext = new StaticApplicationContext();
        applicationContext.refresh();
        applicationContext.close();

        // Person p = applicationContext.getBean(Person.class);
        // System.out.println(p);

        // for (String s : applicationContext.getBeanNamesForAnnotation(Bean.class)) {
        // System.out.println(s);
        // }
    }

}
