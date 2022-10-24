package com.concurrent;

public class MyDaemonThread extends Thread {

  private int i = 0;

  @Override
  public void run() {
    while (true) {
      i++;
      System.out.println(" i = " + i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    MyDaemonThread daemonThread = new MyDaemonThread();
    daemonThread.setDaemon(true);
    daemonThread.start();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("I leave from thread object , and no more print ,that is to say stop");
  }
}
