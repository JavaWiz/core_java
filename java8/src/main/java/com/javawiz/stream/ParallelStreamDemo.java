package com.javawiz.stream;

import com.javawiz.data.CollectionDB;
import com.javawiz.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreamDemo {
 
    public static void main(String[] args) {
 
        long t1, t2;
        List<Employee> eList = new ArrayList<Employee>();
        for(int i=0; i<1000000; i++) {
            eList.addAll(CollectionDB.getEmployees());
        }
 
        /***** Here We Are Creating A 'Sequential Stream' & Displaying The Result *****/
        t1 = System.currentTimeMillis();   
        System.out.println("Sequential Stream Count?= " + eList.stream().filter(e -> e.getSalary() > 15000).count());
 
        t2 = System.currentTimeMillis();
        System.out.println("Sequential Stream Time Taken?= " + (t2-t1) + "\n");
 
        /***** Here We Are Creating A 'Parallel Stream' & Displaying The Result *****/
        t1 = System.currentTimeMillis();        
        System.out.println("Parallel Stream Count?= " + eList.parallelStream().filter(e -> e.getSalary() > 15000).count());
 
        t2 = System.currentTimeMillis();
        System.out.println("Parallel Stream Time Taken?= " + (t2-t1));
    }
}