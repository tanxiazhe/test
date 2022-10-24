package com.concurrencyCookbook.c2;

public class Reader implements Runnable {

    private Pricesinfo pricesInfo;

    public Reader(Pricesinfo pricesInfo) {
        super();
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: price 1: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice1());
            System.out.printf("%s: price 2: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice2());
        }
    }

}
