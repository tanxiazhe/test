package com.concurrent;

public class MyMethod extends Thread {

    // Service service;
    @Override
    public void run() {
        Service service = new Service();
        service.service1();
    }

    public static void main(String[] args) {
        MyMethod method = new MyMethod();
        method.start();
    }
}
