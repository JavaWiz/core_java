package com.javawiz.designpattern.behavioral.strategy;

public class MultiplyConcreteStrategy implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}
