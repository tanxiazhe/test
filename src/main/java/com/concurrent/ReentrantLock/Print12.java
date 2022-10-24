package com.concurrent.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Print12 {
  public static void main(String[] args) {
    Print12 print12 = new Print12();
    MyService myService = print12.new MyService();
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        myService.print1();
      }
    }).start();
    new Thread(() -> {
      for (int i = 0; i < 10; i++) {
        myService.print2();
      }
    }).start();
  }

  class MyService {
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    //    private Condition condition2 = lock.newCondition();

    private boolean flag = true;

    public void print1() {
      try {
        lock.lock();
        while (flag) {
          System.out.println("1");
          flag = false;
          condition1.signal();
        }
        condition1.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    public void print2() {
      try {
        lock.lock();
        while (!flag) {
          System.out.println("2");
          flag = true;
          condition1.signal();
        }
        condition1.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
