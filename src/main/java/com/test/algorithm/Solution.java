package com.test.algorithm;

class Solution {
  public void solution(int N) {
    // write your code in Java SE 8

    for (int i = 0; i < N - 1; i++) {
      System.out.println('L');
    }
    StringBuilder temp = new StringBuilder('L');
    for (int i = 0; i < N - 1; i++) {
      temp.append('L');
    }
    System.out.print('L');
    System.out.print(temp);
  }
}
