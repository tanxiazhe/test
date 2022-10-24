package com.concurrencyCookbook.c1;

import java.util.Random;

public class MyTask implements Runnable {

    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());

        while (true) {
            result = 1000 / (int) (random.nextDouble() * 1000);

            System.out.printf("%s :%f\n", Thread.currentThread().getId(), result);

            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
                return;
            }
        }

    }

    public static void main(String[] args) {
        MyThreadGroup myThreadGroup = new MyThreadGroup("MyThreadGroup");
        MyTask task = new MyTask();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(myThreadGroup, task);
            thread.start();
        }
    }

}
