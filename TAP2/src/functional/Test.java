package functional; /**
 * Created by pedro on 7/17/14.
 */

import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String args[]){
        List<Animal> list = new LinkedList<Animal>();

        Animal a1 = new Animal(3);
        Animal a2 = new Animal(7);
        Animal a3 = new Animal(1);

        list.add(a1);
        list.add(a2);
        list.add(a3);

        list.forEach(elem->elem.talk());




       /* for (Animal a:list)
             a.habla();
*/


    }

}
