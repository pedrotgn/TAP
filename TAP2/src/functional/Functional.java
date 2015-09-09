package functional;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * Created by pedro on 7/18/14.
 */
public class Functional {

    public static void main(String args[]){

        Consumer<Integer>  c = (Integer x) -> { System.out.println(x); };

        BiConsumer<Integer, String> b = (Integer x, String y) -> System.out.println(x + " : " + y);

        Predicate<String> p = (String s) -> { return (s.equals("TAP"));};

        Function<Integer,Integer> f = (Integer elem)->elem+1;

        System.out.println(p.test("TAP"));
        System.out.println(p.test("JO"));
        c.accept(4566);
        b.accept(666,"pedro");
        System.out.println(f.apply(45));


    }
}
