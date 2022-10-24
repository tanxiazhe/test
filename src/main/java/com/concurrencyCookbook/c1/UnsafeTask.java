package com.concurrencyCookbook.c1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {

    private Date startDate;

    @Override
    public void run() {
        startDate = new Date();
        Thread.currentThread();
        System.out.printf("Starting Thread: %s : %s \n", Thread.currentThread().getId(), startDate);

        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.printf("Thread FInished: %s: %s\n", Thread.currentThread().getId(), startDate);
    }

}
