package com.javawiz.algorithm;

public class DrawPattern {
    public static void main(String[] args) {
        patternOne();
    }

    private static void patternOne() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
