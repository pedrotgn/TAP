package structures;

import java.util.*;

public class Test {


    public static void main(String[] args) {
        Collection<String> c;

        c = new ArrayList<>();
        test(c);
        c = new LinkedList<>();
        test(c);
        c = new HashSet<>();
        test(c);
        c = new TreeSet<>();
        test(c);

    }

    public static void test(Collection<String> c) {

        String[] strings = {"uno", "dos", "tres", "cuatro", "tres"};


        c.addAll(Arrays.asList(strings));
        c.forEach(System.out::println);
        //for (String num : c)
         //   System.out.println(num);

        System.out.println("-------------------------");


    }
} 