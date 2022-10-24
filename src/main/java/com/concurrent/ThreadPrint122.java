package com.concurrent;

public class ThreadPrint122 {

  public static void main(String[] args) {
    ThreadPrint122 threadPrint122 = new ThreadPrint122();
    Business business = threadPrint122.new Business();

    Thread mainThread = new Thread(() -> {
      for (int i = 0; i < 6; i++) {
        business.mainRun();
      }
    });
    Thread sonThread = new Thread(() -> {
      for (int i = 0; i < 6; i++) {
        business.run();
      }
    });

    mainThread.start();
    sonThread.start();
  }

  class Business {
    private boolean bShouldSub = true;

    public synchronized void mainRun() {
      while (!bShouldSub) {
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      for (int i = 0; i < 5; i++) {
        System.out.println(Thread.currentThread().getName() + "  i= " + i);
      }
      bShouldSub = false;
      this.notify();
    }

    public synchronized void run() {
      while (bShouldSub) {
        try {
          this.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      for (int i = 0; i < 10; i++) {
        System.out.println(Thread.currentThread().getName() + "  i= " + i);
      }

      bShouldSub = false;
      this.notify();
    }
  }
}
