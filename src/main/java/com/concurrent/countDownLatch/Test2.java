package com.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Test2 {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        Worker2 worker0 = new Worker2("worker0", (long) (Math.random() * 2000 + 3000), countDownLatch);
        Worker2 worker1 = new Worker2("worker1", (long) (Math.random() * 2000 + 3000), countDownLatch);
        Worker2 worker2 = new Worker2("worker2", (long) (Math.random() * 2000 + 3000), countDownLatch);

        worker0.start();
        worker1.start();

        worker0.join();
        // worker1.join();
        countDownLatch.await();

        System.out.println("准备工作就绪");

        worker2.start();
    }
}