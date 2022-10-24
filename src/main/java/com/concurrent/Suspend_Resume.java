/**
 * 
 */
package com.concurrent;

/**
 * @author 
 *
 */
public class Suspend_Resume extends Thread {
	private long i = 0;

	/**
	 * @return the i
	 */
	public long getI() {
		return i;
	}

	/**
	 * @param i
	 *            the i to set
	 */
	public void setI(long i) {
		this.i = i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (true) {
			i++;
		}
	}

	public static void main(String[] args) {
		Suspend_Resume thread = new Suspend_Resume();

		thread.start();

		try {
			Thread.sleep(5000);

			thread.suspend();

			System.out.println(" A = " + System.currentTimeMillis() + "　　i = "
					+ thread.getI());

			thread.resume();
			Thread.sleep(5000);

			thread.suspend();
			System.out.println(" B = " + System.currentTimeMillis() + "　　i = "
					+ thread.getI());

			Thread.sleep(5000);
			System.out.println(" C = " + System.currentTimeMillis() + "　　i = "
					+ thread.getI());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
