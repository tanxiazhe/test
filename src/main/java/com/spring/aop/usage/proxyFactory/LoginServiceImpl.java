package com.spring.aop.usage.proxyFactory;

import com.spring.ioc.springBeanTest.User;

public class LoginServiceImpl implements LoginService {

    @Override
    public boolean login(User user) {
        System.out.println(user);

        if (user == null) {
            return false;
        } else if (user.getUserName() == "xinchun.wang" && user.getPassword() == "123456") {
            return true;
        }

        return false;
    }

}
