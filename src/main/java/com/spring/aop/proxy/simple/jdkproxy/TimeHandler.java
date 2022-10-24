/**
 * 
 */
package com.spring.aop.proxy.simple.jdkproxy;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author 
 *
 */
public class TimeHandler implements InvocationHandler {
    private final Object target;

    TimeHandler(Object target) {

        this.target = target;
    }

    /*
     * (non-Javadoc)
     * 
     * @see InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method)
     */
    @Override
    public void invoke(Object o, Method m) {
        System.out.println("开始时间: " + new Date());
        try {
            m.invoke(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("结束时间: " + new Date());

    }

}
