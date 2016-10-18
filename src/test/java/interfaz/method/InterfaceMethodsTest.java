package interfaz.method;

import java8.interfaz.method.InterfaceOne;
import java8.interfaz.method.TestInterfaceMethodsOne;
import java8.interfaz.method.TestInterfaceMethodsTwo;
import org.junit.Assert;
import org.junit.Test;

public class InterfaceMethodsTest {

    @Test
    public void testInterfaceStaticMethod() {
        Assert.assertEquals("from staticMethod1", InterfaceOne.staticMethod());
        //TestInterface2.staticMethod(); //Error. It is not possible as static methods are not inherited
        //TestInterfaceMethods.staticMethod(); //Error. It is not possible as static methods are not inherited
    }

    @Test
    public void testInterfaceOneOverriddenMethod() {
        TestInterfaceMethodsOne tim = new TestInterfaceMethodsOne();
        Assert.assertEquals("from overridden defaultMethod1 from TestInterfaceMethods", tim.defaultMethod1());
        Assert.assertEquals("from defaultMethod2", tim.defaultMethod2());
    }

    @Test
    public void testInterfaceTwoOverriddenMethod() {
        TestInterfaceMethodsTwo tim = new TestInterfaceMethodsTwo();
        Assert.assertEquals("from overridden defaultMethod1 from TestInterface2", tim.defaultMethod1());
        Assert.assertEquals("from overridden defaultMethod2 from TestInterfaceMethodsTwo", tim.defaultMethod2());
    }
}
