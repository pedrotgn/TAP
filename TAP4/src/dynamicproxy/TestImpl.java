package dynamicproxy;

/**
 * http://javahowto.blogspot.com.es/2011/12/java-dynamic-proxy-example.html
 */

public class TestImpl implements TestIF {
    public String hello(String name) {
        return String.format("Hello %s, this is %s", name, this);
    }
}