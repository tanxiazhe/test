/**
 * 
 */
package com.concurrent;

/**
 * @author
 *
 */
public class MyThreadShare extends Thread {

    private int i = 5;

    /**
     * @param string
     */
    public MyThreadShare(String string) {
        this.setName(string);
    }

    @Override
    synchronized public void run() {
        // i--;
        System.out.println(Thread.currentThread().getName() + " calculate ,  i = " + i--);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        /*
         * MyThreadShare thread = new MyThreadShare("thread");
         * MyThreadShare thread2 = new MyThreadShare("thread2");
         * MyThreadShare thread3 = new MyThreadShare("thread3");
         * MyThreadShare thread4 = new MyThreadShare("thread4");
         * MyThreadShare thread5 = new MyThreadShare("thread5");
         * 
         * thread.start();
         * thread2.start();
         * thread3.start();
         * thread4.start();
         * thread5.start();
         */

        MyThreadShare thread = new MyThreadShare("mythreadshare");
        Thread thread1 = new Thread(thread, "thread1");
        Thread thread2 = new Thread(thread, "thread2");
        Thread thread3 = new Thread(thread, "thread3");
        Thread thread4 = new Thread(thread, "thread4");
        Thread thread5 = new Thread(thread, "thread5");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

}
