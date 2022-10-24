/**
 * 
 */
package com.concurrent;

/**
 * @author 
 *
 */
public class MyThreadStop2 extends Thread {

    /**
     * 
     */
    public MyThreadStop2(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        try {

            this.stop();
        } catch (ThreadDeath e) {
            System.out.println("go in to catch()");
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        MyThreadStop2 thread = new MyThreadStop2("thread");

        thread.start();

    }

}
