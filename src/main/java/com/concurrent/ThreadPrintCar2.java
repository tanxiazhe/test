package com.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrintCar2 {
  private int count;

  Lock lock = new ReentrantLock();
  Condition condition = lock.newCondition();

  void ready(String carName) {
    lock.lock();
    if (count < 10) {
      System.out.println(carName + " ready");
      count++;
      if (count == 10) {
        condition.signalAll();
      }
    }

    lock.unlock();
  }

  void run(String carName) {
    lock.lock();
    if (count < 10) {
      try {
        condition.await();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    //    if (count == 10) {
    else {
      System.out.println(carName + " run");
    }
    lock.unlock();
  }

  public static void main(String[] args) {
    int n = 10;
    ThreadPrintCar2 threadPrintCar2 = new ThreadPrintCar2();
    Thread thread = new Thread(() -> {
      for (int i = 1; i <= n; i++) {
        final int number = i;
        threadPrintCar2.ready("car " + number);
      }
    });
    thread.start();

    Thread thread2 = new Thread(() -> {
      for (int i = 1; i <= n; i++) {
        final int number = i;
        threadPrintCar2.run("car " + number);
      }
    });
    thread2.start();
  }
}
