package dynamic;

/**
 * Created by milax on 20/10/15.
 */
public class MainProxy {
    public static void main(String args[]){
        Foo aFoo = (Foo) DynamicProxy.newInstance(new FooImpl());
        aFoo.doSomething();
        aFoo.doAnother();

    }

}
