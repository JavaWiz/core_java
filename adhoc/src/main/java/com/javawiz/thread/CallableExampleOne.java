package com.javawiz.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

class CallableTask implements Callable<Integer> {
	@Override
	public Integer call() {
		int n = 0;
		for (int i = 0; i <= 10; i++) {
			n += i;
		}
		return n;
	}
}

public class CallableExampleOne {
	public static void main(String args[]) {

		Callable<Integer> c1 = new CallableTask();
		execute(c1); // first way

		Callable<Integer> c2 = new Callable<Integer>() {
			public Integer call() {
				int n = 0;
				for (int i = 0; i <= 10; i++) {
					n += i;
				}
				return n;
			}
		};
		execute(c2);
		
		Callable<Integer> c3 = () -> IntStream.range(0, 11).sum();
		execute(c3);
	}

	public static void execute(Callable<Integer> c) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Integer> future = executor.submit(c);
		try {
			Integer result = future.get(); // waits for the thread to complete
			System.out.println(result);
		} catch (ExecutionException | InterruptedException e) {
			e.printStackTrace();
		}
		executor.shutdown();
	}
}