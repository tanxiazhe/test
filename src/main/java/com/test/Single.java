package com.test;

public class Single {
    private static Single instance;

    private Single() {

    }

    private static class SingleHolder {
        public static Single instance = new Single();
    }

    public static Single getInstance() {
        return SingleHolder.instance;
    }

    public static void main(String[] args) {
        Single single = Single.getInstance();
        Single single2 = Single.getInstance();

        System.out.println(single == single2);
    }
}
