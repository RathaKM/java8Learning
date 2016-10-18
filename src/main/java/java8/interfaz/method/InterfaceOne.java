package java8.interfaz.method;

/*
 * This interface has static as well as default methods
 */
public interface InterfaceOne {
    //static method
    static String staticMethod() {
        return "from staticMethod1";
    }

    //default method 1
    default String defaultMethod1() {
        return "from defaultMethod1";
    }

    //default method 2
    default String defaultMethod2() {
        return "from defaultMethod2";
    }
}
