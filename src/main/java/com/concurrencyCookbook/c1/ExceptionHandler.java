package com.concurrencyCookbook.c1;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler implements UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("An exception has been captured\n");
        System.out.printf("Thread %s\n", t.getId());
        System.out.printf("Exception : %s : %s\n", e.getClass().getName(), e.getMessage());
        System.out.println("Stack trace:");
        e.printStackTrace();
        System.out.printf("Thread status :%s\n", t.getState());
    }

}
