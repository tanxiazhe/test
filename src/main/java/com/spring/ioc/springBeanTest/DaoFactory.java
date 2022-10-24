package com.spring.ioc.springBeanTest;

public class DaoFactory {
    // 静态工厂
    public static final FactoryDao getStaticFactoryDaoImpl() {
        return new FacotryDaoImplStatic();
    }

    // 实例工厂
    public FactoryDao getFactoryDaoImpl() {
        return new FactoryDaoImpl();
    }
}