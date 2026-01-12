package com.javawiz.core;

public class CalculatorImpl {

    public static void main(String[] args) {
        Calculator calculator = (a, b) -> a * b; // Lambda expression for multiplication

        int a = 10;
        int b = 5;

        // Using the calculate method (multiplication)
        int multiplicationResult = calculator.calculate(a, b);
        System.out.println("Multiplication: " + multiplicationResult);

        // Using the default add method
        int additionResult = calculator.add(a, b);
        System.out.println("Addition: " + additionResult);

        // Using the static subtract method
        int subtractionResult = Calculator.subtract(a, b);
        System.out.println("Subtraction: " + subtractionResult);
    }
}
