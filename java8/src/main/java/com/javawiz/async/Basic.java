package com.javawiz.async;

public class Basic {
    public static void main(String[] args) {
        int number = 5;
        Thread newThread = new Thread(() -> {
            System.out.println("Factorial of " + number + " is: " + Calculator.factorial(number));
        });
        newThread.start();
    }
}
