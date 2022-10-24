package com.concurrent;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newScheduledThreadPool;


public class HookTest {
	private static ScheduledExecutorService executorService =
			newScheduledThreadPool(3);

	static {
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			@Override
			public void run() {
				close();
			}
		}));
	}

	private static void close() {
		try {
			System.out.println("clean");
			executorService.shutdown();
			System.out.println(executorService.awaitTermination(10000, TimeUnit.SECONDS));
			System.out.println("end");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			final int index = i;
			try {
				executorService.schedule(new Runnable() {
					@Override
					public void run() {
						System.out.println("yes" + index);
					}
				}, 3, TimeUnit.SECONDS);
				System.out.println("i="+ i + ", add thread");
			} catch (Exception e) {
			}

			if(i == 8){
				System.exit(1);
			}
		}

	}
}
