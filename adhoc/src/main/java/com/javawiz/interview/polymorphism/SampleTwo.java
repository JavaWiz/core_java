package com.javawiz.interview.polymorphism;

public class SampleTwo {

    void display(SampleTwo t){
        System.out.println("SampleTwo");
    }

    void display(String s){
        System.out.println("String");
    }

    public static void main(String[] args) {
        SampleTwo t = new SampleTwo();
        //Compile error - reference to display is ambiguous
        //t.display(null);
    }
}
