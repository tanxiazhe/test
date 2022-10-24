package com.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class RaceWithCountdownLatch {
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(10);
		int i = 0;
		while (i++ < 10) {
			new Thread(()->{

				System.out.println(Thread.currentThread().getName()+" are ready");
				countDownLatch.countDown();
			}).start();
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+", each 10 persons are ready, go running");
	}
}
