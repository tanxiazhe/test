package com.concurrent;

class SynNotExtendsMain {
    public void serviceMethod() {
        System.out.println("in main next sleep begin thread name = " + Thread.currentThread().getName() + " time = "
                + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("in main next sleep end thread name = " + Thread.currentThread().getName() + " time = "
                + System.currentTimeMillis());

    }
}