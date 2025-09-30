package solutions.filter;

import java.util.*;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        List<Integer> filtered = numbers.stream()
                .filter(x -> x % 2 != 0)
                .collect(Collectors.toList());

        System.out.println(filtered); // [1, 3]
    }
}