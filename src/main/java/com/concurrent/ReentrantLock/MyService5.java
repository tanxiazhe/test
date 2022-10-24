package com.concurrent.ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService5 {
  private Lock lock = new ReentrantLock();
  private Condition conditionA = lock.newCondition();
  private Condition conditionB = lock.newCondition();

  public void awaitA() {
    try {
      lock.lock();
      System.out.println(
          "A await time" + System.currentTimeMillis() + " current thread name " + Thread.currentThread()
              .getName());
      conditionA.await();
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
      conditionB.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
      System.out.println("release lock b");
    }
  }

  public void signalAll_A() {
    try {
      lock.lock();
      System.out.println(
          "signalAll A time " + System.currentTimeMillis() + " current thread name " + Thread
              .currentThread().getName());
      conditionA.signalAll();
    } finally {
      lock.unlock();
    }
  }

  public void signalAll_B() {
    try {
      lock.lock();
      System.out.println(
          "signalAll B time " + System.currentTimeMillis() + " current thread name " + Thread
              .currentThread().getName());
      conditionB.signalAll();
    } finally {
      lock.unlock();
    }
  }
}
