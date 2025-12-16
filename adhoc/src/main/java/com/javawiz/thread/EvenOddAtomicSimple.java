package com.javawiz.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class EvenOddAtomicSimple {
    public static void main(String[] args) {
        int LIMIT = 10;
        AtomicInteger number = new AtomicInteger(0);
        Runnable evenTask = () -> {
            while (number.get() <= LIMIT) {
                if (number.get() % 2 == 0) {
                    System.out.println("Even : " + number.getAndIncrement());
                }
            }
        };
        Runnable oddTask = () -> {
            while (number.get() <= LIMIT) {
                if (number.get() % 2 == 1) {
                    System.out.println("Odd  : " + number.getAndIncrement());
                }
            }
        };

        new Thread(oddTask).start();
        new Thread(evenTask).start();
    }
}
