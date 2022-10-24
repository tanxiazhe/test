package com.concurrent.ProducerConsumer.value;

public class Consumer {
  private String lock;

  public Consumer(String lock) {
    this.lock = lock;
  }

  public void getValue() {
    synchronized (lock) {
      if ("".equals(ValueObject.value)) {
        try {
          lock.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println("Current Thread name "+ Thread.currentThread().getName()+" get value " + ValueObject.value);
      ValueObject.value = "";
      lock.notify();
    }
  }
}
