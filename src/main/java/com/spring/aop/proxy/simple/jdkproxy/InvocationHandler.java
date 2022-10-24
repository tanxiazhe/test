package com.spring.aop.proxy.simple.jdkproxy;

import java.lang.reflect.Method;

public interface InvocationHandler {
    public void invoke(Object o, Method m);
}