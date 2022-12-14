package com.concurrencyCookbook.c1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {

    private ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        Thread.currentThread();
        System.out.printf("Starting Thread: %s : %s \n", Thread.currentThread().getId(),
                startDate.get());

        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.printf("Thread FInished: %s: %s\n", Thread.currentThread().getId(), startDate.get());

    }

}
