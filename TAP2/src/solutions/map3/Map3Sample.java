package solutions.map3;


import java.util.Arrays;
import java.util.List;

public class Map3Sample {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("pedro", "lenguajes", "programacion", "Java", "haskell");

        List<Integer> result = Map3.map(list, new StringLength());
        for (Integer elem:result)
            System.out.println(elem);


    }

}
