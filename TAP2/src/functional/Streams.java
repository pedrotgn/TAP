package functional; /**
 *
 * http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 */

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String args[]){

        List<Animal> list = new LinkedList<Animal>();

        Animal a1 = new Animal("loro",24);
        Animal a2 = new Animal("oso",75);
        Animal a3 = new Animal("gato",16);
        Animal a4 = new Animal("perro",6);
        Animal a5 = new Animal("elefante",67);
        Animal a6 = new Animal("mamut",81);

        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);

        Stream<Animal> animalsOver3 = list.stream().filter(p -> p.getAge() > 30);
        animalsOver3.forEach(elem -> System.out.println(elem.getAge()));



        List<Animal> result = list.stream().filter(p -> p.getAge() > 30).collect(Collectors.toList());
        result.forEach(System.out::println);


        long number =  list.stream().filter(p -> p.getAge() > 30).collect(Collectors.counting());
        System.out.println("number "+number);

        list.stream().filter(p -> p.getAge() > 30).count();



    }

}
