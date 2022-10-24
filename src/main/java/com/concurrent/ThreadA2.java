package com.concurrent;

public class ThreadA2 extends Thread {

    private HasSelfPrivateNum hasSelfPrivateNum;

    public ThreadA2(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    @Override
    public void run() {
        hasSelfPrivateNum.addI("a");
    }

    public static void main(String[] args) {

        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        HasSelfPrivateNum hasSelfPrivateNum2 = new HasSelfPrivateNum();
        ThreadA2 a = new ThreadA2(hasSelfPrivateNum);

        a.start();

        ThreadB b = a.new ThreadB(hasSelfPrivateNum2);
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
