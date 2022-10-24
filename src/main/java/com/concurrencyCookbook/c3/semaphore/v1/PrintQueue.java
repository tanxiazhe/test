package com.concurrencyCookbook.c3.semaphore.v1;

import java.util.concurrent.Semaphore;

public class PrintQueue {

    private final Semaphore semaphore;

    public PrintQueue() {
        this.semaphore = new Semaphore(10);
    }

    public void printJob(Object document) {
        try {
            semaphore.acquire();

            long duration = (long) (Math.random() * 1000);
            System.out.printf("%s: PrintQueue: Printing a Job  during %d seconds  permits %d \n",
                    Thread.currentThread().getName(),
                    duration, 10 - semaphore.availablePermits());
            Thread.sleep(duration);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

}
