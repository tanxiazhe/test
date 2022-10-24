package com.spring.ioc.springBeanTest;

public class SpringAction {
    // 注入对象springDao
    private SpringDao springDao;

    // 一定要写被注入对象的set方法
    public void setSpringDao(SpringDao springDao) {
        this.springDao = springDao;
    }

    public void ok() {
        springDao.ok();
    }
}