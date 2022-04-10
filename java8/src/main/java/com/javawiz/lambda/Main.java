package com.javawiz.lambda;

import java.util.ArrayList;
/*
 * Note that lambda expressions can only be used to implement functional interfaces. 
 * In the below example, the lambda expression implements Consumer Functional Interface.
 */
public class Main {

	public static void main(String[] args) {
		// lambda expression implemented
		Vehicle v = () -> System.out.println("Start vehicle");
		// This calls above lambda expression and prints.
		v.start();
		
        // Creating an ArrayList with elements 
        // {1, 2, 3, 4} 
        ArrayList<Integer> list = new ArrayList<Integer>(); 
        list.add(1); 
        list.add(2); 
        list.add(3); 
        list.add(4); 
  
        // Using lambda expression to print all elements 
        list.forEach(n -> System.out.println(n)); 
  
        // Using lambda expression to print even elements 
        list.forEach(n -> { if (n%2 == 0) System.out.println(n); }); 
        
        
        // lambda expression for addition for two parameters 
        // data type for x and y is optional. 
        // This expression implements 'Calculator' interface 
        Calculator add = (int x, int y) -> x + y; 
  
        // lambda expression multiplication for two parameters 
        // This expression also implements 'Calculator' interface 
        Calculator multiply = (int x, int y) -> x * y; 
  
        // Creating an object of Test to call operate using 
        // different implementations using lambda Expressions 
        Main main = new Main(); 
  
        // Add two numbers using lambda expression 
        System.out.println("Addition is " + 
                          main.operate(6, 3, add)); 
  
        // Multiply two numbers using lambda expression 
        System.out.println("Multiplication is " + 
                          main.operate(6, 3, multiply)); 
  
        // lambda expression for single parameter 
        // This expression implements 'Printer' interface 
        Printer fobj = message ->System.out.println("Hello "
                                                 + message); 
        fobj.print("Geek"); 
	}
	
	// Performs FuncInter1's operation on 'a' and 'b' 
    private int operate(int a, int b, Calculator cal) 
    { 
        return cal.operation(a, b); 
    } 
}
