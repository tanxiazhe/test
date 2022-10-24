/**
 * 
 */
package com.concurrent;

/**
 * @author
 *
 */
public class MyThreadInterrupt2 extends Thread {

    /**
     * 
     */
    public MyThreadInterrupt2(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        int i = 500000;
        try {
            while (i > 0) {
                if (Thread.interrupted()) {
                    System.out.println("current status is stop, quit now");
                    // break;
                    throw new InterruptedException();
                }
                i--;
                System.out.println(Thread.currentThread().getName() + " calculate ,  i = " + i);

            }
            System.out.println("again print");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        MyThreadInterrupt2 thread = new MyThreadInterrupt2("thread");

        thread.start();

        try {
            Thread.sleep(1000);
            thread.interrupt();

        } catch (InterruptedException e) {
            System.out.println("main catch.");
            e.printStackTrace();
        }
        System.out.println("end");

    }

}
