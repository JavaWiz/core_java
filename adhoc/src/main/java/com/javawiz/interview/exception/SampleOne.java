package com.javawiz.interview.exception;

public class SampleOne {
    public static void main(String[] args) {
        System.out.println(method());
    }

    private static int method() {
        try{
            return 1;
        } catch(Exception e){
            return 2;
        } finally {
            return 3;
        }
    }
}
