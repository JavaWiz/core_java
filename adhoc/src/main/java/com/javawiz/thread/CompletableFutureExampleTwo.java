package com.javawiz.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExampleTwo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
               CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        // accepts a Function instance, uses it to process the result.
        // returns a Future that holds a value returned by a function.
        CompletableFuture<String> future = completableFuture
                .thenApply(s -> s + " World");
        System.out.println("After thenApply : "+future.get());

        CompletableFuture<Void> futureThenAccept = completableFuture
                .thenAccept(s -> System.out.println("Computation returned: " + s));
        System.out.println("After thenAccept : "+ futureThenAccept.get());

        CompletableFuture<Void> futureThenRun = completableFuture
                .thenRun(() -> System.out.println("Computation finished."));
        System.out.println("After thenAccept : "+ futureThenRun.get());
    }
}
