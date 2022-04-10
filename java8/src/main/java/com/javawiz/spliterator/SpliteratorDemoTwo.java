package com.javawiz.spliterator;

import java.util.ArrayList;
import java.util.Spliterator; 
      
public class SpliteratorDemoTwo  
{ 
    public static void main(String[] args)  
    { 
        // Create an array list for doubles. 
        ArrayList<Integer> arrayList = new ArrayList<>(); 
              
        // Add values to the array list. 
        arrayList.add(1); 
        arrayList.add(2); 
        arrayList.add(-3); 
        arrayList.add(-4); 
        arrayList.add(5); 
              
              
        // Use tryAdvance() to display(action) contents of arraylist. 
        System.out.print("Contents of arraylist:\n"); 
              
        // getting Spliterator object on ArrayList 
        Spliterator<Integer> splitr = arrayList.spliterator(); 
              
        // Use tryAdvance() to display(action) contents of arraylist. 
        // Notice how lambda expression is used to implement accept method 
        // of Consumer interface 
              
        while(splitr.tryAdvance((n) -> System.out.println(n))); 
              
        // Use tryAdvance() for getting absolute values(action) of contents of arraylist. 
              
              
        // Create new list that contains absolute values. 
        ArrayList<Integer> al2 = new ArrayList<>(); 
              
              
              
        splitr = arrayList.spliterator(); 
              
        // Here our action is to get absolute values 
        // Notice how lambda expression is used to implement accept method 
        // of Consumer interface 
        while(splitr.tryAdvance((n) -> al2.add(Math.abs(n)))); 
              
        System.out.print("Absolute values of contents of arraylist:\n"); 
              
        // getting Spliterator object on al2 
        splitr = al2.spliterator(); 
              
              
        while(splitr.tryAdvance((n) -> System.out.println(n))); 
              
    } 
} 