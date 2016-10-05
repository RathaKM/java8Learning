package java8.calculator;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testCalculateUsingInnerClass() {
        Calculator calc = new Calculator();

        //Approach I: with inner class
        class AddOperation implements Operation {
            @Override
            public int compute(int a, int b) {
                return a + b;
            }
        }
        int result = calc.calculate(1, 2, new AddOperation());
        System.out.println("add result: 1+2=" + result);

        class SubOperation implements Operation {
            @Override
            public int compute(int a, int b) {
                return a - b;
            }
        }
        result = calc.calculate(1, 2, new SubOperation());
        System.out.println("sub result: 1-2=" + result);
    }

    @Test
    public void testCalculateUsingAnonymousInnerClass() {
        Calculator calc = new Calculator();
        //Approach II: with anonymous inner class
        int result = calc.calculate(10, 20, new Operation() {
            @Override
            public int compute(int a, int b) {
                return a + b;
            }
        });
        System.out.println("add result: 10+20=" + result);
        result = calc.calculate(10, 20, new Operation() {
            @Override
            public int compute(int a, int b) {
                return a - b;
            }
        });
        System.out.println("sub result: 10-20" + result);
    }

    @Test
    public void testCalculateUsingLambda() {
        //Approach III: with Lambda expressions
        Calculator calc = new Calculator();
        int result = calc.calculate(100, 200, (a, b) -> a + b);
        System.out.println("add result: 100+200=" + result);
        result = calc.calculate(100, 200, (a, b) -> a - b);
        System.out.println("sub result: 100-200=" + result);
    }

    @Test
    public void testCalculateUsingLambdaDeclarative() {
        //Approach IIV: declarative way
        Calculator calc = new Calculator();
        Operation add = (a, b) -> a + b;
        Operation sub = (a,b) -> a-b;
        Operation mul = (a,b) -> a*b;
        Operation div = (a,b) -> a/b;
        int result = calc.calculate(100,200, add);
        System.out.println("add result: 100+200=" + result);
        result = calc.calculate(100, 200, sub);
        System.out.println("sub result: 100-200=" + result);
        result = calc.calculate(100,200, mul);
        System.out.println("mul result: 100+200=" + result);
        result = calc.calculate(100, 200, div);
        System.out.println("div result: 100-200=" + result);
    }
}
