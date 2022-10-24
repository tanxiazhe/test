package com.test.algorithm;

public class Inter {
  long fabi1(int n){
    long res =0;

    if(n ==1) res = 1;


    if(n>1) return n * fabi1(n-1); // n > 10

    return res;

  }

  public static void main(String[] args) {
    Inter i = new Inter();

    System.out.println(i.fabi1(0));
    System.out.println(i.fabi1(0));
  }

}
