package com.javawiz.thread;

class RunnableTask implements Runnable {
	@Override
	public void run() {
		System.out.println("Running");
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
				System.out.println("Running");
			}
		};
		Thread thread2 = new Thread(r2);
		thread2.start();
		
		Runnable r3 = () -> System.out.println("Running");
	    Thread thread3 = new Thread(r3);
	    thread3.start();

	}
}