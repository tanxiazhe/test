/**
 * 
 */
package com.spring.aop.usage.proxyFactory;

import org.springframework.aop.framework.ProxyFactory;

import com.spring.ioc.springBeanTest.User;

/**
 * @author 
 *
 */
public class ProxyLoginTest {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(new BeforeAdvice1());
        factory.addAdvice(new BeforeAdvice2());
        factory.addAdvice(new AfterAdvice1());
        factory.addAdvice(new AfterAdvice2());

        LoginService target = new LoginServiceImpl();
        factory.setTarget(target);
        factory.setProxyTargetClass(false);
        factory.setInterfaces(new Class[] { LoginService.class });

        LoginService service = (LoginService) factory.getProxy();
        System.out.println(service.login(new User("xinchun.wang", "123456")));
    }
}
