package com.spring.ioc;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotationConfigApplicationContext {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

        ctx.register(AppConfig.class);
        ctx.refresh();

        Entitlement ent = (Entitlement) ctx.getBean("entitlement");
        System.out.println(ent.getName());
        System.out.println(ent.getTime());

        ctx.close();

    }
}