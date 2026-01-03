package com.javawiz.thread;

public class VirtualThreadExample {
    public static void main(String[] args) throws InterruptedException {
        Thread.ofVirtual()
            .name("VirtualThread-", 1)
            .unstarted(() -> {
            System.out.println("Hello from a virtual thread!");
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }).start();

        Thread.ofVirtual()
            .start(
            () -> {
                System.out.println("Hello from another virtual thread!");
                System.out.println("Thread name: " + Thread.currentThread().getName());
            }
        );
        // Start a new virtual thread to run a task
        Thread virtualThread = Thread.startVirtualThread(() -> {
            System.out.println("Hello from a virtual thread!");
            System.out.println("Thread name: " + Thread.currentThread().getName());
        });

        // The main thread waits for the virtual thread to complete
        virtualThread.join();
        System.out.println("Main thread finished.");
    }
}
