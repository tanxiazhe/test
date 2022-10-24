package com.concurrent;

public class ThreadA extends Thread {

    private HasSelfPrivateNum hasSelfPrivateNum;

    public ThreadA(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.addI("a");
    }

    public static void main(String[] args) {

        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        ThreadA a = new ThreadA(hasSelfPrivateNum);

        a.start();

        ThreadB b = a.new ThreadB(hasSelfPrivateNum);
        b.start();
    }

    public class ThreadB extends Thread {

        private HasSelfPrivateNum hasSelfPrivateNum;

        public ThreadB(HasSelfPrivateNum hasSelfPrivateNum) {
            this.hasSelfPrivateNum = hasSelfPrivateNum;
        }

        @Override
        public void run() {
            hasSelfPrivateNum.addI("b");
        }
    }
}
