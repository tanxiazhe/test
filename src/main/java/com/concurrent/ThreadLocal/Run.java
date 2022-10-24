package com.concurrent.ThreadLocal;

public class Run {
  public static ThreadLocal tl = new ThreadLocal();

  public static void main(String[] args) {
    if (tl.get() == null) {
      System.out.println("null value");
      tl.set("my value");
    }
    System.out.println(tl.get());
    System.out.println(tl.get());
  }
}
