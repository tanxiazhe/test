/**
 * 
 */
package com.spring.aop.proxy;

import com.designPattern.proxy.demo2.Hello;
import com.designPattern.proxy.demo2.HelloImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 
 *
 */
public class JDKDynamicProxy implements InvocationHandler {
    private final Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    /**
     * 
     */
    private void before() {
        System.out.println("Before");
    }

    /**
     * 
     */
    private void after() {
        System.out.println("after");
    }

    public static void main(String[] args) {
        Hello helloImpl = new HelloImpl();
        JDKDynamicProxy dynamicProxy = new JDKDynamicProxy(helloImpl);

        Hello helloProxy = (Hello) Proxy.newProxyInstance(helloImpl.getClass().getClassLoader(),
                helloImpl.getClass().getInterfaces(), dynamicProxy);
        helloProxy.say("world");
    }
}
