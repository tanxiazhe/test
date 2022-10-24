package com.concurrencyCookbook.c1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileClock implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\n", new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("The fileClock has been interrupted.");
            }
        }
    }

    public static void main(String[] args) {

        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("The fileClock has been interrupted.");
        }

        thread.interrupt();

    }

}
