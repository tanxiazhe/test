package com.concurrent.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService4 {
  private Lock lock = new ReentrantLock();
  private Condition condition = lock.newCondition();

  public void awaitA() {
    try {
      lock.lock();
      System.out.println(
          "A await time" + System.currentTimeMillis() + " current thread name " + Thread.currentThread()
              .getName());
      condition.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
      System.out.println("release lock a");
    }
  }

  public void awaitB() {
    try {
      lock.lock();
      System.out.println(
          "B await time " + System.currentTimeMillis() + " current thread name " + Thread.currentThread()
              .getName());
      condition.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
      System.out.println("release lock b");
    }
  }

  public void signalAll() {
    try {
      lock.lock();
      System.out.println(
          "signalAll time " + System.currentTimeMillis() + " current thread name " + Thread
              .currentThread().getName());
      condition.signalAll();
    } finally {
      lock.unlock();
    }
  }
}
