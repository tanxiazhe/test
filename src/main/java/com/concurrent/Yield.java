package com.concurrent;

public class Yield extends Thread {
    @Override
    public void run() {

        long beginTime = System.currentTimeMillis();

        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            count = count + i + 1;
            Thread.yield();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("time: " + (endTime - beginTime));
    }

    public static void main(String[] args) {
        Yield yield = new Yield();
        yield.start();
    }

}
