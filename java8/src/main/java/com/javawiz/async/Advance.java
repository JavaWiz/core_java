package com.javawiz.async;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;

/**
 * Java 8 introduced CompletableFuture with a combination of a Future and CompletionStage.
 * It provides various methods like supplyAsync, runAsync, and thenApplyAsync for asynchronous programming.
 *
 * So, let's use the CompletableFuture to find the factorial of a number.
 *
 * We don't need to use the ExecutorService explicitly.
 * The CompletableFuture internally uses ForkJoinPool to handle the task asynchronously. Hence, it makes our code a lot cleaner.
 */
@Slf4j
public class Advance {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long number = 5;
        CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> Calculator.factorial(number));
        while (!completableFuture.isDone()) {
            log.info("CompletableFuture is not finished yet...");
        }

        long result = completableFuture.get();
        log.info("Factorial of {} is: {}", number, result);
    }
}
