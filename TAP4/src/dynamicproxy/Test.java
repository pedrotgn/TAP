package dynamicproxy;

/**
 * http://javahowto.blogspot.com.es/2011/12/java-dynamic-proxy-example.html
 */
import java.lang.reflect.*;
public class Test {
    public static void main(String... args) {
        TestIF t = (TestIF) Proxy.newProxyInstance(TestIF.class.getClassLoader(),
                new Class<?>[] {TestIF.class},
                new TestInvocationHandler(new TestImpl()));
        System.out.printf("t.hello(Duke): %s%n", t.hello("Duke"));
        System.out.printf("t.toString(): %s%n", t);
        System.out.printf("t.hashCode(): %H%n", t);
        System.out.printf("t.equals(t): %B%n", t.equals(t));
        System.out.printf("t.equals(new Object()): %B%n", t.equals(new Object()));
        System.out.printf("t.equals(null): %B%n", t.equals(null));
    }
}