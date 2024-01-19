package com.javawiz.algorithm.stack;

public class CharStack {
    char[] array;
    int topOfStack;

    CharStack(int n){
        array = new char[n];
        topOfStack = -1;
    }

    public void push(char ch){
        array[++topOfStack] = ch;
    }

    public char pop(){
        return array[topOfStack--];
    }

    public char peek(){
        return array[topOfStack];
    }

    public boolean isFull(){
        return topOfStack == array.length -1;
    }

    public boolean isEmpty(){
        return topOfStack < 0;
    }
}
