package com.concurrent.ProducerConsumer.value;

public class Client {
  public static void main(String[] args) {
    String lock = "";
    Producer producer = new Producer(lock);
    Consumer consumer = new Consumer(lock);

    Thread producerThread = new Thread(() -> {
      while (true) {
        producer.setValue("tes");
      }
    });
    Thread consumerThread = new Thread(() -> {
      while (true) {
        consumer.getValue();
      }
    });
    producerThread.start();
    consumerThread.start();
  }
}
