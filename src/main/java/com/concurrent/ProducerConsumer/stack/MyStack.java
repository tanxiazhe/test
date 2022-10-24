package com.concurrent.ProducerConsumer.stack;

import java.util.ArrayList;
import java.util.List;

public class MyStack {

  private List list = new ArrayList();

  synchronized public void push() {
    if (list.size() == 1) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    list.add("anyThing " + Math.random());
    System.out.println(" my stack push " + list.size());
    this.notify();
  }
  synchronized public void pop() {
    if (list.size() == 0) {
      try {
        this.wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    list.remove(0);
    System.out.println(" my stack pop " + list.size());
    this.notify();
  }
}
