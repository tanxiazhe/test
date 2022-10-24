package com.concurrent.ReentrantLock;

public class Client2 {
  public static void main(String[] args) {
    MyService2 myService2 = new MyService2();
    new Thread(() -> {
      myService2.await();
    }).start();
  }
}
