package com.baobaotao.proxy.commonMethord;

import com.baobaotao.proxy.ForumService;
import com.baobaotao.proxy.PerformanceMonitor;

public class ForumServiceImpl implements ForumService {
    @Override
    public void removeTopic(int topicId) {

        // ①-1开始对该方法进行性能监视
        PerformanceMonitor.begin("com.baobaotao.jdkproxy.commonMethord.ForumServiceImpl. removeTopic");
        System.out.println("模拟删除Topic记录:" + topicId);
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
    public void removeForum(int forumId) {
        // ②-1开始对该方法进行性能监视
        PerformanceMonitor.begin("com.baobaotao.jdkproxy.commonMethord.ForumServiceImpl. removeForum");
        System.out.println("模拟删除Forum记录:" + forumId);
        try {
            Thread.currentThread();
            Thread.sleep(40);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // ②-2结束对该方法进行性能监视
        PerformanceMonitor.end();
    }

    @Override
    public void testForm(int forumId) {
        // ②-1开始对该方法进行性能监视
        PerformanceMonitor.begin("com.baobaotao.jdkproxy.ForumServiceImpl. testForum");
        System.out.println("模拟测试Forum记录:" + forumId);
        try {
            Thread.currentThread();
            Thread.sleep(2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // ②-2结束对该方法进行性能监视
        PerformanceMonitor.end();
    }
}