/**
 * 
 */
package com.concurrent;

/**
 * @author 
 *
 */
public class MyThreadInteruptAndReturn extends Thread {
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (true) {
			if (this.isInterrupted()) {
				System.out.println("It stoped.");
				return;
			}
			System.out.println("Timer = " + System.currentTimeMillis());
		}
	}

	public static void main(String[] args) {
		MyThreadInteruptAndReturn myThreadInteruptAndReturn = new MyThreadInteruptAndReturn();
		myThreadInteruptAndReturn.start();
	}

}
