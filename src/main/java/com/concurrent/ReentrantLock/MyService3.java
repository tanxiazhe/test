package com.concurrent.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService3 {
  private Lock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();

  public void await() {
    try {
      lock.lock();
      System.out.println("A");
      condition.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
      System.out.println("release lock");
    }
  }

  public void signal() {
    try {
      lock.lock();
      System.out.println("signal time " + System.currentTimeMillis());
      condition.signal();
    } finally {
      lock.unlock();
    }
  }
}
