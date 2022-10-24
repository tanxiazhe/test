package com.concurrent;

public class ThrowExceptionNoLock extends Thread {

    Service service;

    public ThrowExceptionNoLock(Service service) {
        this.service = service;
    }

    public void run() {
        service.testMethod();
    }

    class ThreadB extends Thread {

        Service service;

        public ThreadB(Service service) {
            this.service = service;
        }

        public void run() {
            service.testMethod();
        }
    }

    public static void main(String[] args) {
        Service service = new Service();
        ThrowExceptionNoLock a = new ThrowExceptionNoLock(service);
        a.setName("a");

        ThreadB b = a.new ThreadB(service);
        b.setName("B");

        a.start();
        b.start();

    }
}
