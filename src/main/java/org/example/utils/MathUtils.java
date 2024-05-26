package org.example.utils;

public class MathUtils {
    public int add(int a, int b) {
        return a + b;
    }
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
    public int minus(int a, int b) {
        return a - b;
    }
}
