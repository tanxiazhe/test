package com.concurrent.ThreadLocal;

public class Client1 {

  public static void run1(){
    for(int i = 0 ; i<100;i++){
      Tools.tl.set("ThreadA get value" + (i+1));
      System.out.println("ThreadA get value" + Tools.tl.get());
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void run2(){
    for(int i = 0 ; i<100;i++){
      Tools.tl.set("ThreadB get value" + (i+1));
      System.out.println("ThreadB get value" + Tools.tl.get());
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    new Thread(()->Client1.run1()).start();
    new Thread(()->Client1.run2()).start();

    for(int i = 0 ; i<100;i++){
      Tools.tl.set("Main get value" + (i+1));
      System.out.println("Main get value" + Tools.tl.get());
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
