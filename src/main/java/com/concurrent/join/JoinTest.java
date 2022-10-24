package com.concurrent.join;

public class JoinTest implements Runnable {

    public static int a = 0;

    @Override
    public void run() {
         for (int k = 0; k < 5; k++) {
         a = a + 1;
         }
        try {
            System.out.println("Begin sleep");
            Thread.sleep(3000);
            System.out.println("End sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Runnable r = new JoinTest();
        Thread t = new Thread(r);
        t.start();
         for (int i = 0; i < 300; i++) {
         System.out.print(i);
         }
         System.out.println();

        try {
            t.join(2000);
            System.out.println("joinFinish");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a);
    }
}