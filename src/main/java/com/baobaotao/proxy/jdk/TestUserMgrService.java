package com.baobaotao.proxy.jdk;

import java.lang.reflect.Proxy;

import com.spring.aop.proxy.simple.jdkproxy.UserMgr;
import com.spring.aop.proxy.simple.jdkproxy.UserMgrImpl;

public class TestUserMgrService {
    public static void main(String[] args) {

        // ①希望被代理的目标业务类
        UserMgr target = new UserMgrImpl();

        // ②将目标业务类和横切代码编织到一起
        PerformanceHandler handler = new PerformanceHandler(target);

        // ③根据编织了目标业务类逻辑和性能监视横切逻辑的InvocationHandler实例创建代理实例
        UserMgr proxy = (UserMgr) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);

        // ④调用代理实例
        proxy.addUser();
        proxy.delUser();
    }
}