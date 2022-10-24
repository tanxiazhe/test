/**
 * 
 */
package com.spring.aop.usage.proxyFactory;

import com.spring.ioc.springBeanTest.User;

/**
 * @author 
 *
 */
public interface LoginService {

    /**
     * @param user
     * @return
     */
    boolean login(User user);

}
