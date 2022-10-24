/**
 * 
 */
package com.concurrent.deadLock;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 
 *
 */
public class NoLock {

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {

                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("Thread name: %s, Order NO:%s\r\n", Thread.currentThread(), getOrderNumber());
                }
            });

        }
        System.out.println("wait main thread to countdown");
        latch.countDown();
        System.out.println(" main thread countdown!");
        executorService.shutdown();
    }

    public static String getOrderNumber() {
        SimpleDateFormat simpleDateFormate = new SimpleDateFormat("YYYYMMDDHHMMSS");
        return simpleDateFormate.format(new Date());
    }

}
