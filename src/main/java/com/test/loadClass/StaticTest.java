package com.test.loadClass;

public class StaticTest {
    int a = 110;

    public static void main(String[] args) {
        staticFunction();
    }

    static StaticTest st = new StaticTest();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }
    static int b = 112;
    public static void staticFunction() {
        System.out.println("4");
    }


}