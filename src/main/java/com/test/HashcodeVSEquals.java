package com.test;

public class HashcodeVSEquals {
  public static void main(String[] args) {
    String a = "abc";
    String b = "abc";
    System.out.println("== " + a == b);
    System.out.println("hashcode: " + (a.hashCode() == b.hashCode()));
    System.out.println("equals: " + a.equals(b));
    System.out.println(a.intern().equals(b.intern()));
    System.out.println(a.intern() == (b.intern()));
  }
}
