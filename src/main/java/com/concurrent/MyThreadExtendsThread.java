/**
 * 
 */
package com.concurrent;

/**
 * @author 
 *
 */
public class MyThreadExtendsThread extends Thread {

    public MyThreadExtendsThread() {
        System.out.println("constructor : " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run : " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        MyThreadExtendsThread myThreadExtendsThread = new MyThreadExtendsThread();
        myThreadExtendsThread.run();
        System.out.println("id = " + myThreadExtendsThread.getId());
        System.out.println("id = " + Thread.currentThread().getId());

    }

}
