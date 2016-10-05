package java8.calculator;

public class Calculator {
    public int calculate(int a, int b, Operation c) {
        return c.compute(a, b);
    }
}
