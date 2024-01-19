package com.javawiz.algorithm.stack;

public class IntStack {
    int[] array;
    int topOfStack;

    public IntStack(int size){
        array = new int[size];
        topOfStack = -1;
    }

    public void push(int element){
        array[++topOfStack] = element;
    }

    public int pop(){
        return array[topOfStack--];
    }

    public int peek(){
        return array[topOfStack];
    }

    public boolean isEmpty(){
        return topOfStack == 1;
    }

    public boolean isFull(){
        return topOfStack == array.length - 1;
    }

    public int currentSize(){
        return topOfStack + 1;
    }
}
