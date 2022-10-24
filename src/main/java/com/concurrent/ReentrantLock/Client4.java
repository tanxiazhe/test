package com.concurrent.ReentrantLock;

public class Client4 {
  public static void main(String[] args) {
    MyService4 myService4 = new MyService4();
    new Thread(() -> {
      myService4.awaitA();
    }).start();
    new Thread(() -> {
      myService4.awaitB();
    }).start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    myService4.signalAll();
  }
}
