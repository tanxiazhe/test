package com.baobaotao.proxy.cglib;

import com.baobaotao.proxy.jdk.ForumServiceImpl;

public class TestForumService {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        ForumServiceImpl forumService = // ①
                (ForumServiceImpl) proxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }
}