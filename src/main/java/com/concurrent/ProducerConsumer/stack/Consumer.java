package com.concurrent.ProducerConsumer.stack;

public class Consumer {
  private MyStack myStack;

  public Consumer(MyStack myStack) {
    this.myStack = myStack;
  }

  public void popService(){
    myStack.pop();
  }
}
