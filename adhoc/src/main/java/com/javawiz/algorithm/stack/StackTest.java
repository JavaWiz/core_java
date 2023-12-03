package com.javawiz.algorithm.stack;

public class StackTest {
    public static void main(String[] args) {
        IntStack is = new IntStack(5);
        is.push(2);
        is.push(5);
        is.push(1);
        System.out.println("before pop size : "+is.currentSize());
        System.out.println("pop : "+is.pop());
        System.out.println("after pop size : "+is.currentSize());
        System.out.println("pop : "+is.pop());
        System.out.println("after pop size : "+is.currentSize());
        is.push(4);
        is.push(8);
        is.push(7);
        System.out.println("peek : "+is.peek());
        is.push(3);
        is.push(9);
        System.out.println("size : "+is.currentSize());
    }
}
