/**
 * 
 */
package com.concurrent;

/**
 * @author 
 *
 */
public class CountOperate extends Thread {
    /**
     * 
     */
    public CountOperate() {
        System.out.println(" countOperate -- begin");
        System.out.println(" countOperate Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println(" countOperate this.getName() = " + this.getName());
        System.out.println(" countOperate -- end");
    }

    @Override
    public void run() {
        System.out.println(" run -- begin");
        System.out.println(" run Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println(" run this.getName() = " + this.getName());
        System.out.println(" run -- end");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();

        // countOperate.start();
        //
        Thread thread = new Thread(countOperate);
        thread.setName("A");
        thread.start();
    }

}
