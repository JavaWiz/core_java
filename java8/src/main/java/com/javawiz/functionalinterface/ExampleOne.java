package com.javawiz.functionalinterface;

public class ExampleOne {
    public static void main(String[] args) {
        My1stFnalInterface myFunctionalInterface = new ExampleOne()::message;
        System.out.println(myFunctionalInterface.get());

        My2ndFnalInterface function = new ExampleOne()::message;
        function.get("Ranjan");

        MyFunctionalInterface static_message = ExampleOne::static_message;
        static_message.firstWork();
    }

    String message(String name){
        System.out.println("Hello "+name);
        return "Hello "+name;
    }

    String message(){
        return "Hello User";
    }

    static void static_message(){
        System.out.println("Static Method Reference");
    }
}

interface My1stFnalInterface {
    String get();
}

interface My2ndFnalInterface {
    String get(String name);
}


@FunctionalInterface
interface MyFunctionalInterface {
    void firstWork();

    String toString();

    default void anyOtherWork(){}
}


