package com.javawiz.pattern_matching;

public class Main {

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(new Point(0, 0), new Point(4, 3));

        System.out.println("Area of Circle: " + calculateArea(circle));
        System.out.println("Area of Rectangle: " + calculateArea(rectangle));
    }

    public static double calculateArea(Shape shape) {
        return switch (shape) {
            case Circle(double r) -> Math.PI * r * r;
            case Rectangle(Point(var x1, var y1), Point(var x2, var y2)) -> // Nested pattern matching
                Math.abs(x2 - x1) * Math.abs(y2 - y1);
        };
    }
}
