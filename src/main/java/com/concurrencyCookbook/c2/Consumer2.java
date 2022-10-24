package com.concurrencyCookbook.c2;

import java.util.Random;

public class Consumer2 implements Runnable {

    private Buffer buffer;

    public Consumer2(Buffer buffer) {
        super();
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.hasPendingLines()) {
            String line = buffer.get();
            processLine(line);
        }
    }

    private void processLine(String line) {

        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
