/**
 * 
 */
package com.concurrent;

/**
 * @author 
 *
 */
public class MyThreadIsAlive extends Thread {
    @Override
    public void run() {
        Thread.currentThread().setName("run");
        System.out.println("runnable " + Thread.currentThread().getName() + " isAlive = " + this.isAlive());
    }

    public static void main(String[] args) {

        MyThreadIsAlive thread = new MyThreadIsAlive();
        thread.run();
        thread.start();
    }

}
