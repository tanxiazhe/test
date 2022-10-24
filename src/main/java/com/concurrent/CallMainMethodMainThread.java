/**
 * 
 */
package com.concurrent;

/**
 * @author 
 *
 */
public class CallMainMethodMainThread {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("run");
                System.out.println("runnable " + Thread.currentThread().getName());
            }
        });

        thread.start();

        System.out.println("main " + Thread.currentThread().getName());
        thread.run();

        CallMainMethodMainThread callMainMethodMainThread = new CallMainMethodMainThread();
        Thread thread2 = new Thread(callMainMethodMainThread.new MyRunnable(), "myRunnableThread");
        thread2.start();

        Thread thread3 = new Thread(thread2, "thread3");
        thread3.start();
    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(" my runnable " + Thread.currentThread().getName());
        }

    }
}
