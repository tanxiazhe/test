/**
 * 
 */
package com.spring.ioc.springBeanTest;

/**
 * @author 
 *
 */
public class SpringDaoImpl implements SpringDao {

    @Override
    public void ok() {
        System.out.println("Spring Dao process ok!");
    }

    @Override
    public void save(User user) {
        System.out.println("Spring Dao save " + user);

    }

}
