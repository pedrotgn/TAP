package functional; /**
 * Created by pedro on 7/17/14.
 */

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Streams {

    public static void main(String args[]){

        List<Animal> list = new LinkedList<Animal>();

        Animal a1 = new Animal(3);
        Animal a2 = new Animal(7);
        Animal a3 = new Animal(1);

        list.add(a1);
        list.add(a2);
        list.add(a3);

        Stream<Animal> animalsOver3 = list.stream().filter(p -> p.getAge() > 3);
        animalsOver3.forEach(elem->System.out.println(elem.getAge()));


    }

}
