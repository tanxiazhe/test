package com.test.adapter;

import java.util.concurrent.Callable;

public class RunnableAdapteObjectToCallable
    implements Runnable {
  Callable callable;

  public RunnableAdapteObjectToCallable(Callable callable){
    this.callable = callable;
  }

  @Override
  public void run() {
    try {
      callable.call();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
