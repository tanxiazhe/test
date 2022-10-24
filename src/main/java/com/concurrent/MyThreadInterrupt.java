/**
 * 
 */
package com.concurrent;

/**
 * @author
 *
 */
public class MyThreadInterrupt extends Thread {

    /**
     * 
     */
    public MyThreadInterrupt(String name) {
        this.setName(name);
    }

    @SuppressWarnings({ "static-access" })
    @Override
    public void run() {
        int i = 500000;
        while (i > 0) {
            i--;
            System.out.println(this.currentThread().getName() + " calculate ,  i = " + i);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        MyThreadInterrupt thread = new MyThreadInterrupt("thread");

        thread.start();

        try {
            Thread.sleep(1000);
            thread.interrupt();
            // System.out.println("stop 1? " + thread.interrupted());
            // System.out.println("stop 2? " + thread.interrupted());
            System.out.println("stop 1? " + thread.isInterrupted());
            System.out.println("stop 2? " + thread.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch.");
            e.printStackTrace();
        }

        Thread.currentThread().interrupt();
        System.out.println("stop 1? " + Thread.interrupted());
        System.out.println("stop 2? " + Thread.interrupted());
    }

}
