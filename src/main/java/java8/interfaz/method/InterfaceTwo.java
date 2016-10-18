package java8.interfaz.method;

/*
* This interface extends the TestInterfaceOne and making the default methods as abstract and overridden
*/
public interface InterfaceTwo  extends InterfaceOne {

    //make default method overridden
    default String defaultMethod1() {
        return "from overridden defaultMethod1 from TestInterface2";
    }

    //make default method abstract
    String defaultMethod2();
}
