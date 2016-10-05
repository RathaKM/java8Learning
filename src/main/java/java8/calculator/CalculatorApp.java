package java8.calculator;

public class CalculatorApp {

    public static void main(String args[]) {
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
        //////////////////////////////////////////////////////////////////////

        //Approach II: with anonymous inner class
        result = calc.calculate(10, 20, new Operation() {
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
        ///////////////////////////////////////////////////////////////////////

        //Approach III: with Lambda expressions
        Operation add = (a, b) -> a + b;
//        main.java.java8.calculator.Operation sub = (a,b) -> a-b;
//        main.java.java8.calculator.Operation mul = (a,b) -> a*b;
//        main.java.java8.calculator.Operation div = (a,b) -> a/b;
        result = calc.calculate(100, 200, (a, b) -> a + b);
        //result = calc.calculate(100,200, add);
        System.out.println("add result: 100+200=" + result);
        result = calc.calculate(100, 200, (a, b) -> a - b);
        System.out.println("sub result: 100-200=" + result);


    }


}
