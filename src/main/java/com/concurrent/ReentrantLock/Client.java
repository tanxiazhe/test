package com.concurrent.ReentrantLock;

public class Client {
  public static void main(String[] args) {
    MyService myService = new MyService();
    new Thread(() -> {
      myService.testMethod();
    }).start();
    new Thread(() -> {
      myService.testMethod();
    }).start();
    new Thread(() -> {
      myService.testMethod();
    }).start();new Thread(() -> {
      myService.testMethod();
    }).start();new Thread(() -> {
      myService.testMethod();
    }).start();new Thread(() -> {
      myService.testMethod();
    }).start();



  }
}
