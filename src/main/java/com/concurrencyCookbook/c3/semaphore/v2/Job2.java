package com.concurrencyCookbook.c3.semaphore.v2;

public class Job2 implements Runnable {

    private PrintQueue2 printQueue;

    public Job2(PrintQueue2 printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());

        printQueue.printJob(new Object());

        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }

}
