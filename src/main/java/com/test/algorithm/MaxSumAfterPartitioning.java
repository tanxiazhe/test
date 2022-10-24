package com.test.algorithm;

import java.util.Arrays;

public class MaxSumAfterPartitioning {
    public int maxSumAfterPartitioning3(int[] arr, int k) {
        System.out.println(Arrays.toString(arr));
        int m = arr.length;
        int dp[] = new int[arr.length + 1];

        for (int i = 1; i <= m; i++) {
            int max = 0;
            System.out.println(" i = "+i);
            for (int step = 1; step <= k && ((i - step) >= 0); step++) {
                System.out.print("     step = "+(step));
                System.out.print("  i-step = "+(i-step));
                System.out.print("  arr[i-step] = "+arr[i-step]);
                max = Math.max(max, arr[i - step]);
                System.out.println(" max = " + max);
                dp[i] = Math.max(dp[i], dp[i - step] + step * max);
            }
        }

        return dp[m];
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int res = 0;
        int m;
        m = arr.length + 1;
        System.out.println(m);
        int dp[][] = new int[m][m];
        for (int i = 1; i < m; i++) {
            dp[i][i] = arr[i - 1];
            //            System.out.println(dp[i][i]);
        }
        for (int i = 1; i < m - 1; i++) {
            dp[i][i + 1] = Math.max(arr[i - 1], arr[i]) * 2;
            System.out.println(dp[i][i + 1]);
        }

        for (int step = 2; step < m - 1; step++) {
            System.out.format("step = %d\n", step);
            for (int j = 1; j < m; j++) {
                System.out.format(" j = %d\n", j);
                for (int kk = 1; kk <= Math.min(k, step) && (j + step < m); kk++) {
                    System.out.format("     kk = %d \n", kk);
                    System.out.format("             j+step = %d ", (j + step));
                    dp[j][step + j] =
                        Math.max(max(arr, j - 1, j + step - 1), dp[j][kk] + dp[kk + 1][j + step]);
                    System.out.format(" dp[%d][%d] = %d\n", j, step + j, dp[j][step + j]);
                }
            }
        }
        return dp[1][m - 1];
    }

    public int max(int[] a, int s, int e) {
        System.out.format(" a[%d]= %d, a[%d] = %d, ", s, a[s], e, a[e]);
        int max = 0;
        int i = s;
        while (i <= e) {

            max += a[i];

            i++;
        }
        System.out.print("max = " + max);
        return max;
    }

    public int maxSumAfterPartitioning2(int[] A, int K) {
        System.out.println(Arrays.toString(A));
        int N = A.length, dp[] = new int[N];
        for (int i = 0; i < N; ++i) {
            int curMax = 0;
            System.out.println("i=" + i);
            for (int k = 1; k <= K && i - k + 1 >= 0; ++k) {
                System.out.format("     k= %d , curMax = %d, A[%d]= %d , %s", k, curMax, i - k + 1,
                    A[i - k + 1], Arrays.toString(dp));
                curMax = Math.max(curMax, A[i - k + 1]);
                System.out.format(",  curMax = %d\n", curMax);
                dp[i] = Math.max(dp[i], (i >= k ? dp[i - k] : 0) + curMax * k);
            }
        }
        return dp[N - 1];
    }

    public static void main(String[] args) {
        MaxSumAfterPartitioning maxSumAfterPartitioning = new MaxSumAfterPartitioning();
        System.out.println(
            maxSumAfterPartitioning.maxSumAfterPartitioning3(new int[]{1, 15, 7, 9, 2, 10}, 3));
        System.out.println(
            maxSumAfterPartitioning.maxSumAfterPartitioning2(new int[]{1, 15, 7, 9, 2, 10}, 3));
    }
}
