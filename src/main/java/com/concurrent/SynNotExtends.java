package com.concurrent;

public class SynNotExtends extends SynNotExtendsMain {
    synchronized public void serviceMethod() {
        System.out.println("in sub next sleep begin thread name = " + Thread.currentThread().getName() + " time = "
                + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("in sub next sleep end thread name = " + Thread.currentThread().getName() + " time = "
                + System.currentTimeMillis());
        super.serviceMethod();
    }

}
