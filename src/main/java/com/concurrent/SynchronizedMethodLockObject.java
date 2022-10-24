package com.concurrent;

public class SynchronizedMethodLockObject {
    synchronized void methodA() {
        System.out.println(" begin methodA threadName = " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
