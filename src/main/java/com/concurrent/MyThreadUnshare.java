/**
 * 
 */
package com.concurrent;

/**
 * @author
 *
 */
public class MyThreadUnshare extends Thread {

    private int i = 5;

    /**
     * 
     */
    public MyThreadUnshare(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        while (i > 0) {
            i--;
            System.out.println(Thread.currentThread().getName() + " calculate ,  i = " + i);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        MyThreadUnshare thread = new MyThreadUnshare("thread");
        MyThreadUnshare thread2 = new MyThreadUnshare("thread2");
        MyThreadUnshare thread3 = new MyThreadUnshare("thread3");
        MyThreadUnshare thread4 = new MyThreadUnshare("thread4");
        MyThreadUnshare thread5 = new MyThreadUnshare("thread5");

        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }

}
