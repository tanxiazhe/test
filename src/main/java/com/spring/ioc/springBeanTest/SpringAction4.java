/**
 * 
 */
package com.spring.ioc.springBeanTest;

/**
 * @author 
 *
 */
public class SpringAction4 {
    // 注入对象
    private FactoryDao factoryDao;

    public void factorySave() {
        factoryDao.saveFactory();
    }

    // 注入对象的set方法
    public void setFactoryDao(FactoryDao factoryDao) {
        this.factoryDao = factoryDao;
    }
}
