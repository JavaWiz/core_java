package com.javawiz.thread;

public class VirtualThreadExample {
    public static void main(String[] args) throws InterruptedException {
        // Start a new virtual thread to run a task
        // Using Thread.startVirtualThread() method to create and start a virtual thread in one step.
        // This is a simpler way to create and start a virtual thread.
        // The main thread continues executing while the virtual thread runs concurrently
        Thread virtualThread = Thread.startVirtualThread(() -> {
            System.out.println("Hello from a virtual thread!");
            System.out.println("Thread name: " + Thread.currentThread().getName());
        });

        // The main thread waits for the virtual thread to complete
        virtualThread.join();
        System.out.println("Main thread finished.");

        // Using Thread.ofVirtual().unstarted() to create a virtual thread without starting it immediately.
        // This allows for more control over when the thread starts.
        // Here, we create a virtual thread and start it later.
        Thread.ofVirtual()
            .name("VirtualThread-", 1)
            .unstarted(() -> {
            System.out.println("Hello from a virtual thread!");
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }).start();

        // Thread.ofVirtual() builder: This provides more control, such as naming the thread and then starting it.
        // Here, we create and start a virtual thread using the builder pattern.
        // Using Thread.ofVirtual().start() to create and start a virtual thread in one step.
        Thread.ofVirtual()
            .start(
            () -> {
                System.out.println("Hello from another virtual thread!");
                System.out.println("Thread name: " + Thread.currentThread().getName());
            }
        );
    }
}
