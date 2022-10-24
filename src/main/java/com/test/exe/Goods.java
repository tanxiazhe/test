package com.test.exe;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Goods {
	Deque<String> deque ;
	int size;
	int i = 100;
	public Goods(int size){
		this.size = size;
		deque = new ArrayDeque<>(size);
	}

	void put(){
			deque.offer("prod");

	}

	String get(){
		return 	deque.poll();

	}

	public int getSize() {
		return size;
	}
}
