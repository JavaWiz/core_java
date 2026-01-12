package com.javawiz.core;

@FunctionalInterface
public interface Calculator {
    int calculate(int a, int b);

    default int add(int a, int b) {
        return a + b;
    }

    static int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }
}
