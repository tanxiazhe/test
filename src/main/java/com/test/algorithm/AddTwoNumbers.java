package com.test.algorithm;

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        long n = getNumber(l1) + getNumber(l2);

        System.out.println(" n=" + n);
        int i = 1, j = 0;
        while (n / i != 0) {
            i = i * 10;
            j++;
        }
        System.out.println(" j = " + j);
        int[] res = new int[j];
        int l = 0;
        int k = 1;
        while (l < j) {
            System.out.println((n / k % 10));
            res[l] = (int) (n / k % 10);
            k = k * 10;
            System.out.println(" res[l] = " + res[l] + " l= " + l + " k= " + k + " i= " + i);
            l++;
        }
        l = 0;

        for (int w = 0; w < res.length; w++)
            System.out.println(res[w]);
        System.out.println("///////");
        ListNode p, h, r = new ListNode(0);
        h = r;
        while (j > 0) {
            p = new ListNode(res[l++]);
            p.next = null;
            r.next = p;
            r = r.next;
            j--;
        }

        return h.next;

    }

    public static long getNumber(ListNode l1) {
        if (l1 == null)
            return 0;
        long a = 0;
        ListNode p, h, r;
        r = new ListNode(l1.val);
        h = r;
        l1 = l1.next;
        while (l1 != null) {
            p = new ListNode(l1.val);
            p.next = null;
            r.next = p;
            r = r.next;
            l1 = l1.next;
        }
        System.out.println("  reverse the listnode ");
        printListNode(h);
        int i = 0;
        while (h != null) {
            a += h.val * Math.pow(10, i++);
            h = h.next;
        }

        System.out.println("\ngetNumber: " + a);
        return a;

    }

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1, l2, l3;
        int[] a = { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
                9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9,
                9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 },
                b = { 1 };

        l1 = getListNode(a);
        l2 = getListNode(b);
        System.out.println("\n l1====");
        printListNode(l1);
        System.out.println("\n l2====");
        printListNode(l2);
        System.out.println("\n l3==addTwoNumbers==");
        l3 = addTwoNumbers2(l1, l2);
        printListNode(l3);

    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {

            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }

            d.next = new ListNode(sum % 10);
            d = d.next;
            System.out.println(" sum=" + sum);
            sum /= 10;
        }
        System.out.println(" sum=" + sum);
        if (sum == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }

    static ListNode getListNode(int[] a) {
        ListNode h, r, tmp;
        r = new ListNode(0);
        h = r;
        for (int i = 0; i < a.length; i++) {
            tmp = new ListNode(a[i]);
            r.next = tmp;
            r = r.next;
        }
        return h.next;
    }

    static void printListNode(ListNode h) {
        while (h != null) {
            System.out.print(h.val + "  ");
            h = h.next;
        }
    }
}