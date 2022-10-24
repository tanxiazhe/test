package com.concurrent.ThreadLocal;

import java.util.Date;

public class Run2 {
  public static ThreadLocal tl = new ThreadLocal();

  public static void main(String[] args) {
    for (int i = 0; i < 20; i++) {
      if (tl.get() == null) {
        System.out.println("null value");
        tl.set(new Date());
      }
      System.out.println(tl.get());
      System.out.println(tl.get());
    }
  }
}
