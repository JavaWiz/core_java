package com.javawiz.thread;

public class EvenOddPrinter implements Runnable {
    private final String label;
    private final Object lock;
    private final int max;
    private int number;

    public EvenOddPrinter(String label, Object lock, int i, int max) {
        this.label = label;
        this.lock = lock;
        this.number = i;
        this.max = max;
    }

    public void run() {
        while (number <= max) {
            synchronized (lock) {
                System.out.println(label+number);
                number += 2;
                lock.notify();
                try {
                    if (number <= max) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
