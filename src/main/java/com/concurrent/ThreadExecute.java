package com.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecute {

    private static final int corePoolSize = 2; // 线程池维护线程的最少数量
    private static final int maximumPoolSize = 4; // 线程池维护线程的最大数量
    private static final long keepAliveTime = 3; // 线程池维护线程所允许的空闲时间
    private static final int PRODUCETASKMAXNUMBER = 10;

    private static void processMessageTask() {
        // 创建等待队列
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(2);
        // 构造一个线程池{这个策略重试添加当前的任务，他会自动重复调用 execute() 方法，直到成功}
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
                TimeUnit.SECONDS, bqueue, new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 1; i <= PRODUCETASKMAXNUMBER; i++) {
            try {
                threadPool.execute(new MyThread());
            } catch (Exception e) {
                System.err.println("thread pool is error, content::" + e);
            }
        }
    }

    public static void main(String[] args) {
        processMessageTask();
    }
}

// 子类不能比父类抛出更多的异常
class MyThread implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2 * 1000);
                System.out.println(Thread.currentThread().getName() + "正在执行。。。");
            } catch (Exception e) {

            }
        }
    }
}