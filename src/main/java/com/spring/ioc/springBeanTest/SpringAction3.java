/**
 * 
 */
package com.spring.ioc.springBeanTest;

/**
 * @author 
 *
 */
public class SpringAction3 {
    // 注入对象
    private FactoryDao staticFactoryDao;

    public void staticFactorySave() {
        staticFactoryDao.saveFactory();
    }

    // 注入对象的set方法
    public void setStaticFactoryDao(FactoryDao staticFactoryDao) {
        this.staticFactoryDao = staticFactoryDao;
    }
}
