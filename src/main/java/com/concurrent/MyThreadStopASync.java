/**
 * 
 */
package com.concurrent;

/**
 * @author 
 *
 */
public class MyThreadStopASync extends Thread {

    private final SynchronizedObject object;

    public MyThreadStopASync(SynchronizedObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.printString("b", "bb");
    }

    public static void main(String[] args) {
        SynchronizedObject object = new SynchronizedObject();
        MyThreadStopASync thread = new MyThreadStopASync(object);
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
        System.out.println(object.getUsername() + " " + object.getPassword());
    }
}
