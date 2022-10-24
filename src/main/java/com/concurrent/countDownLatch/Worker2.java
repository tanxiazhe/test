package com.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * 工作者类
 * 
 * @author ThinkPad
 * 
 */
public class Worker2 extends Thread {

    // 工作者名
    private String name;
    // 第一阶段工作时间
    private long time;

    private CountDownLatch countDownLatch;

    public Worker2(String name, long time, CountDownLatch countDownLatch) {
        this.name = name;
        this.time = time;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "开始工作" + " sleep time " + time);
            Thread.sleep(time);
            System.out.println(name + "第一阶段工作完成");

            countDownLatch.countDown();

            Thread.sleep(2000); // 这里就姑且假设第二阶段工作都是要2秒完成
            System.out.println(name + "第二阶段工作完成");
            System.out.println(name + "工作完成，耗费时间=" + (time + 2000));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}