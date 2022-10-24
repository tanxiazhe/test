package com.concurrent.join;

public class Test {

    public static void main(String[] args) throws InterruptedException {

        Worker worker0 = new Worker("worker0", (long) (Math.random() * 2000 + 33000));
        Worker worker1 = new Worker("worker1", (long) (Math.random() * 2000 + 13000));
        Worker worker2 = new Worker("worker2", (long) (Math.random() * 2000 + 3000));

        worker0.start();
        worker1.start();

        worker2.start();
        worker0.join();
        // worker1.join();
        System.out.println("准备工作就绪");

    }
}