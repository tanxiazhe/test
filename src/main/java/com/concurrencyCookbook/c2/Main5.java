package com.concurrencyCookbook.c2;

public class Main5 {

    public static void main(String[] args) {
        Pricesinfo pricesInfo = new Pricesinfo();
        Reader reader[] = new Reader[5];
        Thread thread1[] = new Thread[5];
        for (int i = 0; i < 5; i++) {
            reader[i] = new Reader(pricesInfo);
            thread1[i] = new Thread(reader[i]);
        }
        Writer writer = new Writer(pricesInfo);
        Thread thread2 = new Thread(writer);

        for (int i = 0; i < 5; i++) {
            thread1[i].start();
        }

        thread2.start();

    }

}
