package com.javawiz.interview.polymorphism;

public class SampleOne {
    public static void main(String[] args) {
        Parent p = new Child();
        p.display(10);
    }
}

class Parent {
    Child display(int i){
        System.out.println("parent");
        return null;
    }
}

class Child extends Parent {
    //Uncomment and test it

    /*Parent display(int i){//Compile error - Parent is not compatible with Child
        System.out.println("child");
        return null;
    }*/
}

