package com.javawiz.thread;

public class EvenOddWithSynchronizedExample {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread evenThread = new Thread(new EvenOddPrinter("Even:", lock, 0, 10));
        Thread oddThread = new Thread(new EvenOddPrinter("Odd:", lock, 1, 10));
        evenThread.start();
        oddThread.start();
    }
}
