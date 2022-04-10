package com.javawiz.lambda;

public class LambdaExampleOne {
    public static void main(String[] args) {

        Arithmetic add = ArithmeticUtils::add;
        System.out.println(add.operation(12, 13));

        Arithmetic sub = ArithmeticUtils::subtract;
        System.out.println(sub.operation(12, 13));

        Arithmetic mul = (a, b) -> a * b;
        System.out.println(mul.operation(12, 13));

        Arithmetic div = (a, b) -> a / b;
        System.out.println(div.operation(12, 13));
    }
}

interface Arithmetic {
    int operation(int a, int b);
}

class ArithmeticUtils {
    public static int add(int i, int j){
        return i+j;
    }

    public static int subtract(int i, int j){
        return i-j;
    }

}


