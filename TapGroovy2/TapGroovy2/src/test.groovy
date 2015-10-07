import groovy.util.GroovyTestCase


// http://groovy.codehaus.org/Unit+Testing

class MyTest extends GroovyTestCase {
    void testSomething() {
        assert 1 == 1
        assert 2 + 2 == 4 : "We're in trouble, arithmetic is broken"
    }
}