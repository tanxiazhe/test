package com.test.exe;

import java.util.concurrent.Semaphore;

public class Producer extends Thread{
	Semaphore semaphore;
	Goods goods;
	public  Producer(Semaphore semaphore,Goods goods){
		this.semaphore = semaphore;
		this.goods = goods;
	}

	@Override
	public void run() {
		super.run();
		try {
			semaphore.acquire();
			int size = goods.getSize();
			int i = 0;
			while(i<size) {
				goods.put();
				i++;
			}
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
