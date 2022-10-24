package com.test.exe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args){
		Semaphore semaphore = new Semaphore(2);

		Goods goods = new Goods(10);
		Producer producer = new Producer(semaphore, goods);
		Consumer consumer = new Consumer(semaphore, goods);
		producer.start();
		consumer.start();
	}
}
