package com.concurrent;

public class ThreadA3 extends Thread {

    SynchronizedMethodLockObject lockObject;

    public ThreadA3(SynchronizedMethodLockObject lockObject) {
        this.lockObject = lockObject;
    }

    public void run() {
        lockObject.methodA();
    }

    class ThreadB extends Thread {

        SynchronizedMethodLockObject lockObject;

        public ThreadB(SynchronizedMethodLockObject lockObject) {
            this.lockObject = lockObject;
        }

        public void run() {
            lockObject.methodA();
        }
    }

    public static void main(String[] args) {
        SynchronizedMethodLockObject lockObject = new SynchronizedMethodLockObject();
        ThreadA3 a = new ThreadA3(lockObject);
        a.setName("A");

        ThreadB b = a.new ThreadB(lockObject);
        b.setName("B");

        a.start();
        b.start();

    }
}
