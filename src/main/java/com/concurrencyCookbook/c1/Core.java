package com.concurrencyCookbook.c1;

import java.util.concurrent.TimeUnit;

public class Core {

    public static void main(String[] args) {
        // UnsafeTask task = new UnsafeTask();
        SafeTask task = new SafeTask();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
