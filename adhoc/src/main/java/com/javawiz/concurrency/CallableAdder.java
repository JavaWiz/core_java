package com.javawiz.concurrency;

import java.util.concurrent.Callable;

/**
 * CallableAdder class implement callable to do the Partial sum on group
 */
public class CallableAdder implements Callable<Integer> {
    private Integer operand1;
    private Integer operand2;

    public CallableAdder(Integer operand1, Integer operand2){
       this.operand1 = operand1;
       this.operand2 = operand2;
    }

    @Override
    public Integer call() throws Exception {
        // TODO Auto-generated method stub
        System.out.println(Thread.currentThread().getName()+" says : partial Sum for " + operand1 + " and "+ operand2+ " is "  +(operand1+operand2));
        return operand1+operand2;
    }
}
