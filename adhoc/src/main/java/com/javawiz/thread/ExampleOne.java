package com.javawiz.thread;

class RunnableTask implements Runnable {
	@Override
	public void run() {
		int n = 0;
		for (int i = 0; i <= 10; i++) {
			n += i;
		}
		System.out.println(n);
	}
}

public class ExampleOne {
	public static void main(String args[]) {
		Runnable r1 = new RunnableTask();
		Thread thread1 = new Thread(r1);
		thread1.start();

		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				int n = 0;
				for (int i = 0; i <= 10; i++) {
					n += i;
				}
				System.out.println(n);
			}
		};
		Thread thread2 = new Thread(r2);
		thread2.start();
		
		Runnable r3 = () -> {
			int n = 0;
			for (int i = 0; i <= 10; i++) {
				n += i;
			}
			System.out.println(n);
		};
	    Thread thread3 = new Thread(r3);
	    thread3.start();

	}
}