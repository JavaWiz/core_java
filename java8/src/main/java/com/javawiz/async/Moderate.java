package com.javawiz.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Since Java 5, the Future interface provides a way to perform asynchronous operations using the FutureTask.
 *
 * We can use the submit method of the ExecutorService to perform the task asynchronously and return the instance of the FutureTask.
 *
 * So, let's find the factorial of a number:
 */
public class Moderate {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long number = 5;
        ExecutorService threadpool = Executors.newCachedThreadPool();
        Future<Long> futureTask = threadpool.submit(() -> Calculator.factorial(number));
        /*
            Here, we've used the isDone method provided by the Future interface
            to check if the task is completed.
            Once finished, we can retrieve the result using the get method.
         */
        while (!futureTask.isDone()) {
            System.out.println("FutureTask is not finished yet...");
        }
        long result = futureTask.get();
        System.out.println("Factorial of " + number + " is: " + result);
        threadpool.shutdown();
    }
}
