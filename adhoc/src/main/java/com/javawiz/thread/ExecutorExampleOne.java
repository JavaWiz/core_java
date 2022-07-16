package com.javawiz.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExampleOne {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Creates an Executor that uses a single worker thread operating off an unbounded queue.
		ExecutorService es1 = Executors.newSingleThreadExecutor();
		// Creates a thread pool that reuses a fixed number of threads operating off a shared unbounded queue.
		ExecutorService es2 = Executors.newFixedThreadPool(10);
		// Creates a thread pool that can schedule commands to run after a given delay, or to execute periodically.
		ExecutorService es3 = Executors.newScheduledThreadPool(10);
		
		//The execute method takes a Runnable, and executes it asynchronously.
		es1.execute(new Runnable() {
		    public void run() {
		    	System.out.println(Thread.currentThread().getName()+" : A task");
		    }
		});
		//es1.shutdown();
		
		//This method takes a Runnable but returns a Future object. 
		//This object returns null when the Runnable has finished executing.
		Future<?> future = es1.submit(new Runnable() {
		    public void run() {
		        System.out.println(Thread.currentThread().getName()+" : A task");
		    }
		});
		System.out.println(future.get());//Blocks until the Runnable has finished
		es1.shutdown();
		
		//This version of the method takes a Callable, 
		//and returns a Future object with a result when it has finished executing.
		Future<String> future1 = es2.submit(new Callable<String>() {
		    public String call() {
		        return Thread.currentThread().getName() + " : A callable";
		    }
		});
		System.out.println(future1.get());//Blocks until the Callable has finished
		es2.shutdown();
		
		invokeAnyExample();
		
		invokeAllExample();
	}
	
	/*
	 * This method executes the given tasks returning the result of one that has completed successfully. 
	 * You have no guarantee about which of the Callable's results you'll get, just one of the ones that finish. 
	 * When one of the tasks complete or throws an exception, the rest are canceled.
	 */
	public static void invokeAnyExample() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		List<Callable<String>> callables = new ArrayList<Callable<String>>();
		callables.add(new Callable<String>() {
		    public String call() {
		        return "Callable 1";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() {
		        return "Callable 2";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() {
		        return "Callable 3";
		    }
		});
		String result;
		try {
			result = executorService.invokeAny(callables);
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executorService.shutdown();
	}
	
	/*
	 * This method executes the given tasks, 
	 * returning a list of Futures holding their status and results when all complete. 
	 * Future.isDone() is true for each element of the returned list. 
	 * A completed task could have terminated either normally or by throwing an exception.
	 * 
	 * When you are done using the ExecutorService you should shut it down, so the threads do not keep running. 
	 * To terminate the threads inside the ExecutorService you call its shutdown() method. 
	 * The ExecutorService will not shut down immediately, but it will no longer accept new tasks, and once all threads have finished current tasks, the ExecutorService shuts down. If you want to shut down the ExecutorService immediately, you can call the shutdownNow() method. This will attempt to stop all executing tasks right away, and skips all non-processed tasks.
	 */

	public static void invokeAllExample() throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		List<Callable<String>> callables = new ArrayList<Callable<String>>();
		callables.add(new Callable<String>() {
		    public String call() {
		        return "Callable 1";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() {
		        return "Callable 2";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() {
		        return "Callable 3";
		    }
		});
		List<Future<String>> futures = executorService.invokeAll(callables);
		for(Future<String> f : futures){
		    System.out.println(f.get());
		}
		executorService.shutdown();
	}
}
