package com.baobaotao.proxy.commonMethord;

import com.baobaotao.proxy.ForumService;

public class TestForumService {
    public static void main(String[] args) {
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);

        forumService.testForm(2);
    }
}