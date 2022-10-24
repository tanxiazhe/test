package com.concurrencyCookbook.c2;

public class Main6 {

    public static void main(String[] args) {

        FileMock fileMock = new FileMock(100, 10);
        Buffer buffer = new Buffer(20);

        Producer2 producer = new Producer2(fileMock, buffer);
        Thread threadProducer = new Thread(producer, "Producer");

        Consumer2 consumers[] = new Consumer2[3];
        Thread threadConsumers[] = new Thread[3];
        for (int i = 0; i < 3; i++) {
            consumers[i] = new Consumer2(buffer);
            threadConsumers[i] = new Thread(consumers[i], "Consumer " + i);
        }

        threadProducer.start();

        for (int i = 0; i < 3; i++) {
            threadConsumers[i].start();
        }
    }

}
