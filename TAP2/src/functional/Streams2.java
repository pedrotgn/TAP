package functional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collectors.html
 */
public class Streams2 {


    public static void main(String args[]) {

        List<Animal> people = new LinkedList<Animal>();

        Animal a1 = new Animal("loro", 24);
        Animal a2 = new Animal("oso", 75);
        Animal a3 = new Animal("gato", 16);
        Animal a4 = new Animal("perro", 6);
        Animal a5 = new Animal("elefante", 67);
        Animal a6 = new Animal("mamut", 81);

        people.add(a1);
        people.add(a2);
        people.add(a3);
        people.add(a4);
        people.add(a5);
        people.add(a6);


        // Accumulate names into a List
        List<String> list = people.stream().map(Animal::getName).collect(Collectors.toList());

        // Accumulate names into a TreeSet
        Set<String> set = people.stream().map(Animal::getName).collect(Collectors.toCollection(TreeSet::new));
        set.forEach(System.out::println);

        // Convert elements to strings and concatenate them, separated by commas
        String joined = people.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println(joined);
        // Compute sum of salaries of employee
        int total = people.stream()
                .collect(Collectors.summingInt(Animal::getAge));
        System.out.println("cnt:"+total);
/*
        // Group employees by department
        Map<Department, List<Employee>> byDept
                = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // Compute sum of salaries by department
        Map<Department, Integer> totalByDept
                = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingInt(Employee::getSalary)));*/

        // Partition students into passing and failing
        Map<Boolean, List<Animal>> oldAnimals =
                people.stream()
                        .collect(Collectors.partitioningBy(s -> s.getAge() >=30));

        System.out.println("old ones:");
        oldAnimals.get(true).forEach(System.out::println);
        System.out.println("young ones:");
        oldAnimals.get(false).forEach(System.out::println);

    }

}
