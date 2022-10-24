package com.spring.aop.proxy.simple.jdkproxy;
import java.lang.reflect.Method;

public class $ProxyUserMgr implements UserMgr{

    InvocationHandler h;

    public $ProxyUserMgr(InvocationHandler h) {
        this.h = h;
    }

    @Override
    public  void addUser() {
        try {
               Method md = UserMgr.class.getMethod("addUser");
               h.invoke(this, md);
        }catch(Exception e) {
             e.printStackTrace();
        }
    }

    @Override
    public  void delUser() {
        try {
               Method md = UserMgr.class.getMethod("delUser");
               h.invoke(this, md);
        }catch(Exception e) {
             e.printStackTrace();
        }
    }

}