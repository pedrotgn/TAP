package functional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author MikeW
 */
public class ComparatorTest {

    public static void main(String[] args) {

        List<Person> personList = Person.createShortList();

        // Sort with Inner Class
        personList.sort(new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return p1.getSurName().compareTo(p2.getSurName());
            }
        });

        System.out.println("=== Sorted Asc SurName ===");
        for (Person p : personList) {
            p.printName();
        }

        // Use Lambda instead

        // Print Asc
        System.out.println("=== Sorted Asc SurName ===");
        personList.sort((Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName()));

        for (Person p : personList) {
            p.printName();
        }

        // Print Desc
        System.out.println("=== Sorted Desc SurName ===");
        personList.sort((p1, p2) -> p2.getSurName().compareTo(p1.getSurName()));

        for (Person p : personList) {
            p.printName();
        }

    }
}