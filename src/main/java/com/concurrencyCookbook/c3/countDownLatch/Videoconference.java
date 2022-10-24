package com.concurrencyCookbook.c3.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {

    private final CountDownLatch controller;

    public Videoconference(int number) {
        this.controller = new CountDownLatch(number);
    }

    public void arrive(String name) {
        System.out.printf("%s has arrived.\n", name);
        controller.countDown();
        System.out.printf("VideoConference : waiting for %d participants.\n", controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference : initialization: %d participants.\n", controller.getCount());
        try {
            controller.await();
            System.out.println("All participants have come. Let's start...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
