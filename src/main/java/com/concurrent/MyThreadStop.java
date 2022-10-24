/**
 * 
 */
package com.concurrent;

/**
 * @author 
 *
 */
public class MyThreadStop extends Thread {

    /**
     * 
     */
    public MyThreadStop(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100000; i++) {
                System.out.println("i = " + i++);
            }
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");

        } catch (InterruptedException e) {
            System.out.println("Stop while thread is sleeping, go to catch! " + this.isInterrupted());
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        MyThreadStop thread = new MyThreadStop("thread");

        thread.start();

        try {
            Thread.sleep(1000);
            thread.interrupt();
            // thread.stop();
        } catch (InterruptedException e) {
            System.out.println("main catch.");
            e.printStackTrace();
        }
        System.out.println("end");

    }

}
