/**
 * 
 */
package com.concurrent;

/**
 * @author 
 *
 */
public class MyThreadRunRandomByStart extends Thread {

    private final int i;

    /**
     * 
     */
    public MyThreadRunRandomByStart(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(" i = " + i);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        MyThreadRunRandomByStart thread = new MyThreadRunRandomByStart(1);
        MyThreadRunRandomByStart thread2 = new MyThreadRunRandomByStart(2);
        MyThreadRunRandomByStart thread3 = new MyThreadRunRandomByStart(3);
        MyThreadRunRandomByStart thread4 = new MyThreadRunRandomByStart(4);
        MyThreadRunRandomByStart thread5 = new MyThreadRunRandomByStart(5);

        thread.setName("MyThread");
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }

}
