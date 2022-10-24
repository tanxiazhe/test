package com.test.algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class MinTreeSum {
  public int mctFromLeafValues(int[] arr) {
    if (arr.length < 2) {
      return 0;
    }
    int[][] m = new int[arr.length][arr.length];
    int[][] dp = new int[arr.length][arr.length];

    for (int i = 0; i < arr.length; i++) {
      m[i][i] = arr[i];
      for (int j = i + 1; j < arr.length; j++) {
        m[i][j] = Math.max(m[i][j - 1], arr[j]);
      }
    }
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if(i == j) dp[i][j] = arr[i];
        else if (j - i == 1) {
          dp[i][j] = arr[i] * arr[j];
        } else {
          dp[i][j] = Integer.MAX_VALUE;
        }
      }
    }

    printArray(arr, dp, m);

    for (int k = 2; k <= arr.length; k++) {
      System.out.println("k="+k);
      for (int l = 0; l+k <= arr.length; l++) {
        int r = l+k-1;
        for (int j = l; j < r; j++) {
          System.out.print(" l="+l+", r="+r +" , j="+j +" , dp="+ dp[l][r]);
          System.out.print(", dp[l][j]= "+dp[l][j]+" , dp[j+1][r]="+dp[j+1][r]+" , m[l][j]="+m[l][j]+", m[j+1][r]="+ m[j+1][r]);
          dp[l][r] = Math.min(dp[l][r], dp[l][j] + dp[j+1][r] + m[l][j] * m[j+1][r]);
          System.out.println(", update dp = "+dp[l][r]);
        }
      }
    }
    return dp[0][arr.length - 1];
  }

  private void printArray(int[] arr, int[][] dp, int[][] m) {
    System.out.println(Arrays.toString(arr));
    System.out.println("dp");
    for (int i = 0; i < arr.length; i++) {
      System.out.println(Arrays.toString(dp[i]));
    }

    System.out.println("m");
    for (int i = 0; i < arr.length; i++) {
      System.out.println(Arrays.toString(m[i]));
    }
  }
  public static void main(String[] args) {
//    MinTreeSum minTreeSum = new MinTreeSum();
//    minTreeSum.mctFromLeafValues(new int[]{7, 3, 5, 6, 8});
    TreeSet<Integer> set = new TreeSet<Integer>() ;
    set.addAll((Arrays.asList(7,3,5,6,8,8)));
    System.out.println(set.toString());
    System.out.println(set.pollLast());
    System.out.println(set.pollLast());

    List a = Arrays.asList(7,3,6,6);
    Collections.sort(a);
    System.out.println(a);
    Collections.sort(a,Collections.reverseOrder());
    System.out.println(a);
    System.out.println(a.get(0));
    System.out.println(a.get(1));

  }
}
