package com.concurrent;

public class PublicVar {

    String username = "A";
    String password = "AA";

    synchronized public void setValue(String username, String password) {
        this.username = username;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.password = password;
        System.out.println("setValue method thread name= " + username + " = password = " + password);

    }

    synchronized public void getValue() {
        System.out.println("getValue method thread name= " + username + " = password = " + password);
    }
}
