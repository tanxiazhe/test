package com.baobaotao.proxy.commonMethord;

import com.spring.aop.proxy.simple.jdkproxy.UserMgr;

public class TestUserMgrService {
    public static void main(String[] args) {

        // ①希望被代理的目标业务类
        UserMgr target = new UserMgrServiceImpl();

        // ④调用代理实例
        target.addUser();
        target.delUser();
    }
}