package com.test.algorithm;

public class ReverseNumber {
    public static Long reverse(Long bi) {
        Long result = 0L;

        while (bi != 0) {
            Long tail = bi % 10;
            Long tempResult = result * 10 + tail;

            if ((tempResult - tail) / 10 != result) {
                return 0L;
            }

            result = tempResult;
            bi = bi / 10;
        }

        return result;
    }

}
