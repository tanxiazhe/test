/**
 * 
 */
package com.concurrent;

/**
 * @author 
 *
 */
public class CountOperate2 extends Thread {
    /**
     * 
     */
    public CountOperate2() {
        System.out.println(" CountOperate2 -- begin");
        System.out.println(" CountOperate2 Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println(" CountOperate2 this.getName() = " + this.getName());
        System.out.println(" CountOperate22 this.isAlive() = " + this.isAlive());
        System.out.println(" CountOperate2 -- end");
    }

    @Override
    public void run() {
        System.out.println(" run -- begin");
        System.out.println(" run Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println(" run this.getName() = " + this.getName());
        System.out.println(" run this.isAlive() = " + this.isAlive());
        System.out.println(" run -- end");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        CountOperate2 CountOperate2 = new CountOperate2();

        // CountOperate2.start();
        //
        Thread thread = new Thread(CountOperate2);
        System.out.println(" main this.isAlive() = " + thread.isAlive());
        thread.setName("A");
        thread.start();
        System.out.println(" main this.isAlive() = " + thread.isAlive());
    }

}
