package com.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPrintCar {
  private static int count;
  public static volatile boolean flag = false;
  public static AtomicInteger i = new AtomicInteger();

  public ThreadPrintCar(int count) {
    this.count = count;
  }

  public void run(String carName) {
    System.out.println(carName + " start");
  }

  public void ready(String carName) {
    System.out.println(carName + " ready");
  }

  static class Driver implements Runnable {

    private ThreadPrintCar threadPrintCar;

    private String carName;

    public Driver(ThreadPrintCar threadPrintCar, String carName) {
      this.threadPrintCar = threadPrintCar;
      this.carName = carName;
    }

    @Override
    public void run() {
      synchronized (threadPrintCar) {
        //        System.out.println(carName+" "+i.get());
        if (flag == false) {
          threadPrintCar.ready(carName);
          i.incrementAndGet();
          if (i.get() == count) {
            flag = true;
            threadPrintCar.notifyAll();
          }
        }
      }
    }
  }

  static class DriverStart implements Runnable {

    private ThreadPrintCar threadPrintCar;

    private String carName;

    public DriverStart(ThreadPrintCar threadPrintCar, String carName) {
      this.threadPrintCar = threadPrintCar;
      this.carName = carName;
    }

    @Override
    public void run() {
      synchronized (threadPrintCar) {
//        System.out.println("----------"+carName + " " + flag);
        while (flag == false) {
          try {
            threadPrintCar.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        if (flag == true) {
          threadPrintCar.run(carName);
        }
      }
    }
  }

  public static void main(String[] args) {
    int n = 10;
    ThreadPrintCar threadPrintCar = new ThreadPrintCar(n);
    for (int i = 1; i <= n; i++) {
      Driver driver = new Driver(threadPrintCar, "car " + i);
      Thread thread = new Thread(driver);
      thread.start();

      DriverStart driverStart = new DriverStart(threadPrintCar, "car " + i);
      Thread thread2 = new Thread(driverStart);
      thread2.start();
    }
  }
}
