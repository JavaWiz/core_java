package com.javawiz.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorInvokeAllExample {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		
		List<Future<String>> futureTasks = executorService.invokeAll(Arrays.asList(ExecutorInvokeAllExample::algoOne, ExecutorInvokeAllExample::algoTwo));
		
		futureTasks.forEach(res -> {
            try {
                System.out.println(Thread.currentThread().getName()+": Result - " + res.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
		executorService.shutdown();
	}
	
	private static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String algoOne(){
        System.out.println(Thread.currentThread().getName()+": Running algorithm one");
        sleep(1000);
        return "algoOne Result";
    }

    private static String algoTwo(){
        System.out.println(Thread.currentThread().getName()+": Running algorithm two");
        sleep(1000);
        return "algoTwo Result";
    }
}
