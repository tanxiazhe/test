package com.concurrent;

public class MyThreadA extends Thread {

    SynNotExtends sub;

    public MyThreadA(SynNotExtends sub) {
        this.sub = sub;
    }

    public void run() {
        sub.serviceMethod();
    }

    class ThreadB extends Thread {

        SynNotExtends sub;

        public ThreadB(SynNotExtends sub) {
            this.sub = sub;
        }

        public void run() {
            sub.serviceMethod();
        }
    }

    public static void main(String[] args) {
        SynNotExtends sub = new SynNotExtends();
        MyThreadA a = new MyThreadA(sub);
        a.setName("a");

        ThreadB b = a.new ThreadB(sub);
        b.setName("B");

        a.start();
        b.start();

    }
}
