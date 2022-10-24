package com.concurrent;

public class Service {

    synchronized public void service1() {
        System.out.println("service1");
        service2();
    }

    synchronized public void service2() {
        System.out.println("service2");
        service3();
    }

    synchronized public void service3() {
        System.out.println("service3");
    }

    synchronized public void testMethod() {
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("Threadname = " + Thread.currentThread().getName() + " run begintime = "
                    + System.currentTimeMillis());
            int i = 1;
            while (i == 1) {
                if (("" + Math.random()).substring(0, 8).equals("0.123456")) {
                    System.out.println("Threadname = " + Thread.currentThread().getName() + " run exceptiontime = "
                            + System.currentTimeMillis());
                    Integer.parseInt("a");
                }
            }
        } else {
            System.out.println("Thread B run time = " + System.currentTimeMillis());
        }
    }

}
