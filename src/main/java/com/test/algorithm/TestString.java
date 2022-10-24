package com.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class TestString {
    public static void main(String[] args) {
        // String str = "你叫神马？我叫Tesson.";
        // for (int i = 0; i < str.length(); i++) {
        // char item = str.charAt(i);
        // System.out.println(item);
        // }

        // String[] strs = { "a", "ab" };
        // System.out.println(longestCommonPrefix(strs));

        // int[] a = { 82597, -9243, 62390, 83 };
        // System.out.println(" len = " + removeDuplicates(a));
        // threeSum(a);

        // String s = "(]";
        // System.out.println(isValid(s));

        // List<Integer> seq = new ArrayList<Integer>();
        // System.out.println(seq.isEmpty());

        /*
         * String s = "1->2->5->";
         * System.out.println(s.substring(0, s.lastIndexOf("->")));
         */

        // String A = "a";
        // String B = "a";
        // System.out.println(A.lastIndexOf(B.charAt(0)));
        // System.out.println(repeatedStringMatch(A, B));

        // String s = "abccccdd", s2 = "aabccccdd";
        // System.out.println(longestPalindrome(s));
        // System.out.println(findTheDifference(s, s2));

        // System.out.println(judgeCircle("UD"));
        // System.out.println(firstUniqChar("leetcode"));

        // int nums1[] = { 5, 1, 2 };
        // int nums2[] = { 2, 1 };
        // System.out.println(Arrays.toString(intersect(nums1, nums2)));
        // Arrays.sort(nums1);
        // System.out.println(Arrays.toString(nums1));
        //
        // Set<Integer> set = new TreeSet<Integer>();
        // // Collections.addAll(set, nums1);
        // // if you want to use Iterator to print value
        // System.out.println("\nPrint Set Value via Iterator: ");
        //
        // for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();) {
        // Object o = iterator.next();
        // System.out.print(o + " ");
        // }
        //
        // System.out.println("min=" + Collections.min(set));
        // List<List<String>> res = solveNQueens(4);
        // for (List<String> o : res) {
        // for (String s : o) {
        // System.out.print(s);
        // }
        // System.out.println();
        // }
        // String a = "1+-1i";
        // String b = "0+2i";
        // System.out.println("res:" + complexNumberMultiply(a, a));
        String h = "hello";
        System.out.println(countSegments(h));
    }

    static int countSegments(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' '))
                res++;
        return res;
    }

    static int str2Integer(String a) {
        int i = 0, j = 0, sum = 0;
        i = a.length() - 1;

        while (i >= 0) {
            sum += (a.charAt(j++) - '0') * Math.pow(10, i);
            i--;
        }

        return sum;
    }

    static int[] complexNumber(String a) {
        int i = 0, j = 0;
        String a1 = "", a2 = "";
        int r[] = new int[2];
        while (a.charAt(i) != '+') {
            a1 += a.charAt(i);
            i++;
        }
        if (a.charAt(i) == '+') {
            i++;
            for (j = 0; a.charAt(i) != 'i'; j++) {
                a2 += a.charAt(i);
                i++;
            }
        }
        System.out.println("a1=" + a1 + "\na2=" + a2);
        r[0] = Integer.parseInt(a1);
        r[1] = Integer.parseInt(a2);
        return r;
    }

    public static String complexNumberMultiply(String a, String b) {
        int a1[] = new int[2], b1[] = new int[2];
        a1 = complexNumber(a);
        b1 = complexNumber(b);
        int num1 = a1[0] * b1[0] - a1[1] * b1[1], num2 = (a1[0] * b1[1] + a1[1] * b1[0]);
        return num1 + "+" + num2 + "i";
    }

    static public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        int k = 0, find = 0;
        int Q[] = new int[n];
        char Queen[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            Q[i] = -1;
        }

        while (k >= 0) {
            find = 0;
            while (Q[k] < n) {
                Q[k]++;
                if (Q[k] < n && canPlaceQueen(Q, k)) {
                    find = 1;
                    break;
                }
                // System.out.println("Q[k]=" + Q[k] + " k=" + k);
            }
            if (find == 1) {
                if (k == (n - 1)) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            Queen[i][j] = '.';
                        }
                    }
                    for (int i = 0; i < n; i++) {
                        Queen[i][Q[i]] = 'Q';
                    }
                    List<String> queen = new ArrayList<String>();
                    for (int i = 0; i < n; i++) {
                        StringBuilder sb = new StringBuilder();
                        for (int j = 0; j < n; j++) {
                            sb.append(Queen[i][j]);
                            // System.out.print(Queen[i][j]);
                        }
                        System.out.println(sb.toString());
                        queen.add(sb.toString());
                    }
                    res.add(queen);
                    System.out.println();
                    for (List<String> o : res) {
                        for (String s : o) {
                            System.out.print(s);
                        }
                        System.out.println();
                    }

                } else {
                    // System.out.println("find k=" + k);
                    k++;
                }
            } else {
                // System.out.println("k=" + k);
                Q[k] = -1;
                k--;
            }

        }
        return res;

    }

    static boolean canPlaceQueen(int Q[], int k) {
        for (int i = 0; i < k; i++) {
            if (Q[k] == Q[i] || Math.abs(Q[k] - Q[i]) == Math.abs(k - i)) {
                return false;
            }
        }
        return true;
    }

    static void stringBuilder2string() {
        String s;
        StringBuilder sb = new StringBuilder();
        sb.append("s");
        s = sb.toString();
    }

    static Map<Integer, Integer> kv(int[] nums1) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], 1);

            } else {
                map.put(nums1[i], map.get(nums1[i]) + 1);
            }
        }

        return map;

    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0)
            return new int[0];
        Map<Integer, Integer> map1, map2;
        map1 = kv(nums1);
        map2 = kv(nums2);

        int k = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                }
            }
        }

        List<Integer> list = new ArrayList<Integer>();

        for (int i : set) {
            k = map1.get(i) > map2.get(i) ? map2.get(i) : map1.get(i);
            for (int j = 0; j < k; j++) {
                list.add(i);
            }
        }

        int[] a = new int[list.size()];

        k = 0;

        for (int i : list) {
            a[k++] = i;
        }

        return a;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                }
            }
        }

        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                }
            }
        }
        list.toArray();

        return new int[0];

    }

    public static int firstUniqChar(String s) {
        if (s.length() == 0)
            return -1;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        for (Character set : map.keySet()) {
            if (map.get(set) == 1) {
                return s.indexOf(set);
            }
        }

        return -1;
    }

    public static boolean judgeCircle(String moves) {
        if (moves.length() == 0 || moves.length() % 2 != 0)
            return false;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < moves.length(); i++) {
            if (!map.containsKey(moves.charAt(i))) {
                map.put(moves.charAt(i), 1);
            } else {
                map.put(moves.charAt(i), map.get(moves.charAt(i)) + 1);
            }
        }
        int l = 0, r = 0, u = 0, d = 0;
        if (map.containsKey('L')) {
            l = map.get('L');
        }
        if (map.containsKey('R')) {
            r = map.get('R');
        }
        if (map.containsKey('U')) {
            u = map.get('U');
        }
        if (map.containsKey('D')) {
            d = map.get('D');
        }

        if (l == r && u == d) {
            return true;
        }
        return false;

    }

    public static char findTheDifference(String s, String t) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Character res = null;

        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                res = t.charAt(i);
                break;
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }

        if (res == null) {
            for (Character set : map.keySet()) {
                if (map.get(set) < 0) {
                    res = set;
                }
            }
        }

        return res;
    }

    public static int longestPalindrome(String s) {
        int sum = 0;
        if (s == null || s.length() < 0)
            return 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        int i = 0;
        for (Character set : map.keySet()) {
            Integer times = map.get(set);
            if (times % 2 == 0) {
                sum += times;
            } else {
                i++;
                sum += (times - 1);
            }
        }
        if (i > 0) {
            sum++;
        }
        return sum;
    }

    public static int repeatedStringMatch(String A, String B) {
        int index = -1, i = 0, j = 0;
        String s = "";

        j = A.lastIndexOf(B.charAt(0));

        while (s.length() - j - 1 <= B.length()) {
            s += A;
            i++;
            if (s.contains(B)) {
                return i;
            }

        }

        return index;

    }

    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Map<Character, Character> pair = new HashMap<Character, Character>();
        pair.put('{', '}');
        pair.put('[', ']');
        pair.put('(', ')');

        if (s.length() == 2) {
            if (!pair.containsKey(s.charAt(0)) || pair.get(s.charAt(0)) != s.charAt(1)) {
                return false;
            }
            return true;
        }

        Stack<Character> source = new Stack<Character>();
        Stack<Character> target = new Stack<Character>();

        int i = 0;
        while (i < s.length()) {
            source.push(s.charAt(i++));
        }

        while (!source.isEmpty()) {
            if (target.isEmpty()) {
                target.push(source.pop());
            }

            if (!target.isEmpty() && pair.get(source.peek()) == target.peek()) {
                target.pop();
                source.pop();
            }

            if (!target.isEmpty() && pair.get(source.peek()) != target.peek()) {
                target.push(source.pop());
            }
        }

        if (source.isEmpty() && target.isEmpty()) {
            return true;
        }

        return false;
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> seqs = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            System.out.println("seqs " + seqs);
            return seqs;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> seq = new ArrayList<Integer>();
                        seq.add(nums[i]);
                        seq.add(nums[j]);
                        seq.add(nums[k]);
                        Collections.sort(seq);
                        if (!seqs.contains(seq)) {
                            seqs.add(seq);
                            System.out.println(" i, j , k " + nums[i] + nums[j] + nums[k]);
                        }
                    }
                }
            }
        }

        return seqs;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        int min = Integer.MAX_VALUE, l = 0, index = 0;
        for (; l < strs.length; l++) {
            if (strs[l].length() < min) {
                min = strs[l].length();
                index = l;
            }
        }

        if (min == 0)
            return "";

        int i, j;

        for (j = 0; j < min; j++) {
            char item = strs[index].charAt(j);
            for (i = 0; i < strs.length; i++) {

                if (strs[i].charAt(j) != item) {

                    if (j == 0) {
                        return "";
                    } else {
                        return strs[i].substring(0, j);
                    }
                }
            }
        }

        return strs[index];
    }

    public static int removeDuplicates(int[] nums) {
        System.out.println(Arrays.toString(nums));
        if (nums.length < 2)
            return nums.length;

        int m = 1, j;

        for (j = 1; j < nums.length; j++) {
            if (nums[j - 1] != nums[j]) {
                nums[m] = nums[j];
                m++;
            }
        }

        return m;
    }

}