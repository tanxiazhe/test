package com.test.algorithm;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int l = 0, h = str.length;
        int max = 1;
        String res = str[0]+"" ;
        for(int i= 0; i< h; i++){
            for(int j = i+1; j< h; j++) {
                System.out.format("i= %d, j =%d, max = %d\n", i, j, max);
                if (str[i] == str[j] && (j - i + 1 > max) && isPalindrome(s.substring(i, j+1))) {
                    res = s.substring(i, j+1);
                    max = j - i + 1;
                }
            }
        }

        return res;
    }


    public static boolean isPalindrome(String s){
        System.out.println(s);
        char[] str = s.toCharArray();
        if(s.length() %2 == 0) {
            for(int i=0; i< s.length() /2; i++){
                if(str[i] != str [s.length()-1 -i]) return false;
            }
        }else{
            for(int i=0; i<= s.length() /2; i++){
                if(str[i] != str [s.length()-1-i]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(LongestPalindromicSubstring.isPalindrome("a"));
//        System.out.println(LongestPalindromicSubstring.isPalindrome("ab"));
//        System.out.println(LongestPalindromicSubstring.isPalindrome("aba"));
//        System.out.println(LongestPalindromicSubstring.isPalindrome("abab"));
//        System.out.println(LongestPalindromicSubstring.isPalindrome("abba"));

//        System.out.println(LongestPalindromicSubstring.longestPalindrome("a"));
//        System.out.println(LongestPalindromicSubstring.longestPalindrome("aba"));
//        System.out.println(LongestPalindromicSubstring.longestPalindrome("cbbd"));
        System.out.println(LongestPalindromicSubstring.longestPalindrome("babad"));
        System.out.println(LongestPalindromicSubstring.longestPalindrome("ac"));
    }
}
