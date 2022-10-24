package com.concurrent;

import java.util.Random;

public class Mythread2 extends Thread {

    @Override
    public void run() {

        long beginTime = System.currentTimeMillis();

        int addResult = 0;
        for (int j = 0; j < 10; j++)
            for (int i = 0; i < 50000; i++) {
                Random random = new Random();
                random.nextInt();

                addResult += i;
            }

        long endTime = System.currentTimeMillis();

        System.out.println("mythread2 time: " + (endTime - beginTime));

    }

    class Mythread3 extends Thread {

        @Override
        public void run() {

            long beginTime = System.currentTimeMillis();

            int addResult = 0;
            for (int j = 0; j < 10; j++)
                for (int i = 0; i < 50000; i++) {
                    Random random = new Random();
                    random.nextInt();

                    addResult += i;
                }

            long endTime = System.currentTimeMillis();

            System.out.println("mythread3 time: " + (endTime - beginTime));

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Mythread2 mythread2 = new Mythread2();
            mythread2.setPriority(9);
            mythread2.start();

            Mythread3 mythread3 = mythread2.new Mythread3();
            mythread3.setPriority(10);
            mythread3.start();

        }
    }
}
