package com.javawiz.algorithm.stack;

public class StringStack {
    private String[] array;
    private int topOfStack;

    public StringStack(int size){
        array = new String[size];
        topOfStack = -1;
    }

    public void push(String str){
        array[++topOfStack] = str;
    }

    public String pop(){
        return array[topOfStack--];
    }

    public String peek(){
        return array[topOfStack];
    }

    public boolean isEmpty(){
        return topOfStack < 0;
    }

    public boolean isFull(){
        return topOfStack == array.length - 1;
    }

    public int size(){
        return topOfStack + 1;
    }
}
