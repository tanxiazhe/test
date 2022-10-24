package com.concurrent;

public class Main {

    int i = 10;

    synchronized public void operateIMainMethod() {
        i--;
        System.out.println("main print i= " + i);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    class Sub extends Main {
        synchronized public void operateISubMethod() {
            while (i > 0) {
                i--;

                System.out.println("sub print i= " + i);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                this.operateIMainMethod();
            }
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            Main mainClass = new Main();
            Sub sub = mainClass.new Sub();
            sub.operateISubMethod();
        }
    }

    public static void main(String[] args) {
        Main mainClass = new Main();
        MyThread thread = mainClass.new MyThread();
        thread.start();
    }

}
