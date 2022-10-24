package com.concurrent;

public class Priority extends Thread {

    @Override
    public void run() {
        System.out.println(" my thread run priority = " + this.getPriority());

        Mythread2 thread2 = new Mythread2();
        thread2.start();
    }

    public static void main(String[] args) {
        System.out.println(" main thread run priority = " + Thread.currentThread().getPriority());

        Thread.currentThread().setPriority(6);
        System.out.println(" main thread run priority = " + Thread.currentThread().getPriority());

        Priority priority = new Priority();
        priority.start();

    }

    class Mythread2 extends Thread {

        @Override
        public void run() {
            System.out.println(" my thread2 run priority = " + this.getPriority());

        }
    }
}
