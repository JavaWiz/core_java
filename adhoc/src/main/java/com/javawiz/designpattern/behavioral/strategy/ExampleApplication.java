package com.javawiz.designpattern.behavioral.strategy;

import java.util.Scanner;

public class ExampleApplication {
    public static void main(String[] args) {
        //Create context object
        Context context = new Context();
        Scanner sc = new Scanner(System.in);
        //Read first number
        System.out.println("Enter first number: ");
        int first_number =  sc.nextInt();
        //Read last number
        System.out.println("Enter second number: ");
        int second_number =  sc.nextInt();
        //Read the desired action from user input
        System.out.println("Enter action: ");
        String action =  sc.nextLine();

        if ("+".equals(action))
            context.setStrategy(new AddConcreteStrategy());

        if ("-".equals(action))
            context.setStrategy(new SubtractConcreteStrategy());

        if ("*".equals(action))
            context.setStrategy(new MultiplyConcreteStrategy());

        int result = context.executeStrategy(first_number, second_number);
        System.out.println(result);
    }
}
