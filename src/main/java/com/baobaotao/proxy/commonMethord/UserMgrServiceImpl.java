package com.baobaotao.proxy.commonMethord;

import com.baobaotao.proxy.PerformanceMonitor;
import com.spring.aop.proxy.simple.jdkproxy.UserMgr;

public class UserMgrServiceImpl implements UserMgr {
    @Override
    public void addUser() {

        // ①-1开始对该方法进行性能监视
        PerformanceMonitor.begin("com.baobaotao.jdkproxy.commonMethord.UserMgrServiceImpl. addUser");
        System.out.println("模拟添加用户.....:");
        try {
            Thread.currentThread();
            Thread.sleep(20);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // ①-2结束对该方法进行性能监视
        PerformanceMonitor.end();
    }

    @Override
    public void delUser() {
        // ②-1开始对该方法进行性能监视
        PerformanceMonitor.begin("com.baobaotao.jdkproxy.commonMethord.UserMgrServiceImpl. delUser");
        System.out.println("模拟删除用户.....:");
        try {
            Thread.currentThread();
            Thread.sleep(40);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // ②-2结束对该方法进行性能监视
        PerformanceMonitor.end();
    }

}