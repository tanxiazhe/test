/**
 * 
 */
package com.spring.ioc.springBeanTest;

/**
 * @author 
 *
 */
public class FacotryDaoImplStatic implements FactoryDao {

    @Override
    public void saveFactory() {
        System.out.println("Spring Dao save static beanfactory");

    }

}
