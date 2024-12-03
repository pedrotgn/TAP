package functional;


import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args){
        List<Animal> list = new LinkedList<>();

        Animal a1 = new Animal("a",3);
        Animal a2 = new Animal("b",7);
        Animal a3 = new Animal("c",1);

        list.add(a1);
        list.add(a2);
        list.add(a3);

        list.forEach(elem->elem.talk());
        list.forEach(Animal::talk);
        list.forEach(System.out::println);



       /* for (Animal a:list)
             a.habla();
*/


    }

}
