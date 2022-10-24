package com.concurrent;

public class HasSelfPrivateNum {

    int num = 0;

    synchronized public void addI(String username) {
        if (username.equals("a")) {
            num = 100;
            System.out.println("a set over");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            num = 200;
            System.out.println("b set over");
        }

        System.out.println(username + " num = " + num);
    }
}
