package com.test.exe;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Consumer extends  Thread{
	Semaphore semaphore;
	Goods goods;
	public  Consumer(Semaphore semaphore,Goods goods){
		this.semaphore = semaphore;
		this.goods = goods;
	}

	@Override
	public void run() {
		super.run();
		try {
			semaphore.acquire();
			int size = goods.getSize();
			int i = size;
			while(i>=0) {
				goods.get();
				i++;
			}
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
