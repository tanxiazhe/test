package com.concurrencyCookbook.c3.semaphore.v2;

public class Main2 {

    public static void main(String[] args) {

        PrintQueue2 printQueue = new PrintQueue2();

        Thread threads[] = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Job2(printQueue), "Thread" + i);
        }

        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
    }

}
