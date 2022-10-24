package com.test.algorithm;

public class ReverseInteger {

    public static int reverse2(int x) {
        int i = 0;
        while (x != 0) {
            int tmp = x % 10;

            i = i * 10 + tmp;

            x = x / 10;
        }
        return i > 0 ? i : 0;
    }

    public static int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        return (int) res == res ? (int) res : 0;
    }

    public static void main(String[] args) {

        System.out.println(ReverseInteger.reverse2(1222222222));
    }
}
