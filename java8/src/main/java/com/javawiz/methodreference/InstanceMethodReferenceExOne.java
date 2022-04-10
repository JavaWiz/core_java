package com.javawiz.methodreference;

interface Hello {
    void say();  
}  
public class InstanceMethodReferenceExOne {
    public void saySomething(){  
        System.out.println("Hello, this is non-static method.");  
    }  
    public static void main(String[] args) {
        InstanceMethodReferenceExOne methodReference = new InstanceMethodReferenceExOne(); // Creating object
        // Referring non-static method using reference  
            Hello hello = methodReference::saySomething;
        // Calling interface method  
        hello.say();
            // Referring non-static method using anonymous object  
            Hello sayable2 = new InstanceMethodReferenceExOne()::saySomething; // You can use anonymous object also
            // Calling interface method  
            sayable2.say();  
    }  
}  