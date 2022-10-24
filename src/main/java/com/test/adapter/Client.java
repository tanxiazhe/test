package com.test.adapter;

import java.util.concurrent.Callable;

public class Client {
  public static void main(String[] args) {
    Runnable runnable = new RunnableAdapteObjectToCallable(new Callable() {
      @Override
      public Object call() throws Exception {
        System.out.println("call");
        return "call";
      }
    });

    new Thread(runnable).start();
  }
}
