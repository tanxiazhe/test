package com.concurrent;

public class ThreadA4 extends Thread {

    SynchronizedMethodLockObject2 lockObject;

    public ThreadA4(SynchronizedMethodLockObject2 lockObject) {
        this.lockObject = lockObject;
    }

    public void run() {
        lockObject.methodA();
    }

    class ThreadB extends Thread {

        SynchronizedMethodLockObject2 lockObject;

        public ThreadB(SynchronizedMethodLockObject2 lockObject) {
            this.lockObject = lockObject;
        }

        public void run() {
            lockObject.methodB();
        }
    }

    public static void main(String[] args) {
        SynchronizedMethodLockObject2 lockObject = new SynchronizedMethodLockObject2();
        ThreadA4 a = new ThreadA4(lockObject);
        a.setName("A");

        ThreadB b = a.new ThreadB(lockObject);
        b.setName("B");

        a.start();
        b.start();

    }
}
