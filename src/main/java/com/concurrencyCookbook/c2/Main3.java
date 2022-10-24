package com.concurrencyCookbook.c2;

public class Main3 {
    public static void main(String[] args) {
        EventStorage eventStorage = new EventStorage();

        Producer producer = new Producer(eventStorage);
        Thread thread1 = new Thread(producer);

        Consumer consumer = new Consumer(eventStorage);
        Thread thread2 = new Thread(consumer);

        thread2.start();
        thread1.start();

    }
}
