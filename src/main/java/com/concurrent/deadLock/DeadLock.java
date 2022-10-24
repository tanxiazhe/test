package com.concurrent.deadLock;

public class DeadLock {

    public synchronized void method1() {
        System.out.println("1");
    }

    public synchronized void method2() {
        System.out.println("2");
        this.method1();

    }

    public static void main(String[] args) {

        DeadLock deadLock = new DeadLock();

        deadLock.method2();

    }

}