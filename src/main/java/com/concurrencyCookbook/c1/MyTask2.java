package com.concurrencyCookbook.c1;

import java.util.concurrent.TimeUnit;

public class MyTask2 implements Runnable {

    @Override
    public void run() {

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MyThreadFactory myThreadFactory = new MyThreadFactory("MyThreadFactory");

        MyTask2 task = new MyTask2();

        Thread thread;

        System.out.println("Starting the Threads");
        for (int i = 0; i < 2; i++) {
            thread = myThreadFactory.newThread(task);
            thread.start();
        }

        System.out.println("Factory stats: \n");

        System.out.printf("%s\n", myThreadFactory.getStats());
    }

}
