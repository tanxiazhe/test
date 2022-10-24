/**
 * 
 */
package com.spring.aop.proxy;

import java.lang.reflect.Method;

import com.designPattern.proxy.demo2.Hello;
import com.designPattern.proxy.demo2.HelloImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author
 *
 */
public class CGLibDynamicProxy implements MethodInterceptor {

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        Object result = proxy.invokeSuper(obj, args);
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
        CGLibDynamicProxy cgLibProxy = new CGLibDynamicProxy();

        Hello helloProxy = cgLibProxy.getProxy(HelloImpl.class);
        helloProxy.say("world");
    }

}
