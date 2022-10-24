package com.concurrencyCookbook.c3.phaser.v2;

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class Student implements Runnable {

    private Phaser phaser;

    public Student(Phaser phaser) {
        super();
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.printf("%s : Has arrived to do the exam.%s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s : It's going to do the first exercise..%s\n", Thread.currentThread().getName(),
                new Date());
        doExercis1();
        System.out.printf("%s : Has done the first exercise..%s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s : It's going to do the second exercise..%s\n", Thread.currentThread().getName(),
                new Date());
        doExercis2();
        System.out.printf("%s : Has done the second exercise..%s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        System.out.printf("%s : It's going to do the third exercise..%s\n", Thread.currentThread().getName(),
                new Date());
        doExercis3();
        System.out.printf("%s : Has finished the exam.%s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

    }

    private void doExercis1() {
        long duration = (long) (Math.random() * 10);

        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doExercis2() {
        long duration = (long) (Math.random() * 10);

        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void doExercis3() {
        long duration = (long) (Math.random() * 10);

        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
