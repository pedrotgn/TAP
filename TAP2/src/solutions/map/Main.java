package solutions.map;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hola", "mundo", "Java");

        List<Integer> lengths = Map.map(words, String::length);

        System.out.println(lengths); // [4, 5, 4]
    }
}
