package com.concurrent.ProducerConsumer.value;

public class Producer {
  private String lock;

  Producer(String lock) {
    this.lock = lock;
  }

  public void setValue(String value) {
    synchronized (lock) {
      if (!"".equals(ValueObject.value)) {
        try {
          lock.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      System.out.println("Current Thread name "+ Thread.currentThread().getName()+ " Set value " + value);
      ValueObject.value = value;
      lock.notify();
    }
  }
}
