package com.test.algorithm;

public class Fibonacci {
    int getFibonacciByRecurse(int n) {
        int first = 1, second = 1, res = 0;
        if (n == 0) {
            res = 0;
        } else if (n == 1 || n == 2) {
            res = 1;
        } else {
            for (int i = 3; i <= n; i++) {
                res = first + second;
                first = second;
                second = res;
            }
        }
        return res;
    }

    int getFibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return getFibonacci(n - 1) + getFibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.getFibonacci(0));
        System.out.println(fibonacci.getFibonacci(1));
        System.out.println(fibonacci.getFibonacci(2));
        System.out.println(fibonacci.getFibonacci(3));
        System.out.println(fibonacci.getFibonacci(4));
        System.out.println(fibonacci.getFibonacci(5));
        System.out.println("----------getFibonacciByRecurse---------");

        System.out.println(fibonacci.getFibonacciByRecurse(0));
        System.out.println(fibonacci.getFibonacciByRecurse(1));
        System.out.println(fibonacci.getFibonacciByRecurse(2));
        System.out.println(fibonacci.getFibonacciByRecurse(3));
        System.out.println(fibonacci.getFibonacciByRecurse(4));
        System.out.println(fibonacci.getFibonacciByRecurse(5));
    }
}
