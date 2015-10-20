package dynamic;

/**
 * Created by milax on 20/10/15.
 */
public class FooImpl implements Foo {
    @Override
    public void doSomething() {
        System.out.println("I am doing something ....");
    }

    @Override
    public void doAnother() {
        System.out.println("I am doing another thing");
    }
}
