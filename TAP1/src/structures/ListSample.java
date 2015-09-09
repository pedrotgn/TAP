package structures;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by pedro on 9/9/15.
 */
public class ListSample {

    public static void main(String args[]){
        Person p1 = new Person("111","pedro",1);
        Person p2 = new Person("222","pep",2);
        Person p3 = new Person("333","pere",3);

        List<Person> persons = new LinkedList<Person>();

        // What happens if Persons is not set in List ? Can we add a String to the List ? Where is the error ?
        //List persons = new LinkedList();


        persons.add(p1);
        persons.add(p2);
        persons.add(p3);

        for (Person p:persons)
            System.out.println(p);


    }

}
