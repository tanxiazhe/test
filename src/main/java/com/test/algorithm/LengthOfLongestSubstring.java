/**
 * 
 */
package com.test.algorithm;

import java.util.HashSet;

/**
 * @author 
 *
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {

        int i, j, max = 0;
        HashSet<Character> set = new HashSet<Character>();
        char item;

        for (i = 0; i < s.length(); i++) {
            for (j = i; j < s.length(); j++) {
                item = s.charAt(j);
                if (set.contains(item)) {

                    break;
                }
                set.add(item);
            }
            System.out.println("i=" + i + " j=" + j + " max = " + max + " j-i=" + (j - i));
            max = (j - i) < max ? max : (j - i);
            set.clear();
        }

        return max;

    }

    public static void main(String[] args) {
        String s = "c";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
