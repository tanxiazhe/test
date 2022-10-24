package com.concurrent;

public class ThreadPrint12 {
    public static int flag = 0;
    // public static Object this = new Object();

    void print1() {
        synchronized (this) {
            while (flag < 10) {
                System.out.println("1");
                this.notify();
                flag++;
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void print2() {
        synchronized (this) {
            while (flag < 10) {
                System.out.println("2");
                this.notify();
                flag++;
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadPrint12 threadPrint12 = new ThreadPrint12();
        Thread t1 = new Thread(() -> threadPrint12.print1());

        Thread t2 = new Thread(() -> threadPrint12.print2());

        t1.start();
        t2.start();
    }
}