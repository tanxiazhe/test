package com.concurrent.ReentrantLock;

public class Client3 {
  public static void main(String[] args) {
    MyService3 myService3 = new MyService3();
    new Thread(() -> {
      myService3.await();
    }).start();

    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    myService3.signal();
  }
}
