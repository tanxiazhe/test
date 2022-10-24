package com.concurrent.ReentrantLock;

public class Client5 {
  public static void main(String[] args) {
    MyService5 myService5 = new MyService5();
    new Thread(() -> {
      myService5.awaitA();
    }).start();
    new Thread(() -> {
      myService5.awaitB();
    }).start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    myService5.signalAll_A();
  }
}
