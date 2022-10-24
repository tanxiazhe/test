package com.test.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayMerge {

    private static int[] a = { 1, 3, 5, 6, 8, 9 };

    private static int[] b = { 1, 6, 7, 11, 14, 19 };

    public static void main(String[] args) {
        print(merge(a, b));

        int[] c = merge(a, b);
        double median;
        if (c.length % 2 == 0) {
            System.out.println(
                    " c[c.length / 2]=" + c[c.length / 2] + " c[c.length / 2 - 1]) / 2=" + c[c.length / 2 - 1]);
            median = (c[c.length / 2] + c[c.length / 2 - 1]) / (2.0);
            System.out.println(" c[c.length / 2] + c[c.length / 2 - 1] =" + (c[c.length / 2] + c[c.length / 2 - 1]));
            System.out.println("\n 1 median =" + median);
        } else {
            median = c[c.length / 2];
            System.out.println("\n 2 median =" + median);
        }
        System.out.println("\n length=" + c.length + " median =" + median);
    }

    private static int[] merge(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
        return c;
    }

    private static void print(int[] a) {
        for (int i : a) {
            System.out.print(i + ",");
        }
    }

}