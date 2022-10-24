package com.baobaotao.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import com.baobaotao.proxy.PerformanceMonitor;

public class CglibProxy implements MethodInterceptor {
    private final Enhancer enhancer = new Enhancer();

    public Object getProxy(Class<?> clazz) {
        enhancer.setSuperclass(clazz); // ① 设置需要创建子类的类
        enhancer.setCallback(this);
        return enhancer.create(); // ②通过字节码技术动态创建子类实例

    }

    // ③拦截父类所有方法的调用
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        PerformanceMonitor.begin(obj.getClass().getName() + "." + method.getName());// ③-1
        Object result = proxy.invokeSuper(obj, args);// ③-2
        PerformanceMonitor.end();// ③-1通过代理类调用父类中的方法
        return result;
    }
}