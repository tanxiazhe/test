package com.concurrent.ProducerConsumer.stack;

public class Client2 {
  public static void main(String[] args) {
    MyStack myStack = new MyStack();
    Producer producer = new Producer(myStack);
    Consumer consumer = new Consumer(myStack);

    Thread producerThread = new Thread(() -> {
      while (true) {
        producer.pushService();
      }
    });
    Thread consumerThread = new Thread(() -> {
      while (true) {
        consumer.popService();
      }
    });

    producerThread.start();
    consumerThread.start();
  }
}
