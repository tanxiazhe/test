package com.concurrent.ProducerConsumer.stack;

public class Producer {
  private MyStack myStack;

  public Producer(MyStack myStack){
    this.myStack  = myStack;
  }

  public void pushService(){
    myStack.push();
  }
}
