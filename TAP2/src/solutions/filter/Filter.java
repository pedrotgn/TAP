package solutions.filter;

import java.util.*;
import java.util.function.Predicate;

public class Filter {
    public static <T> List<T> filter(List<T> input, Predicate<T> condition) {
        List<T> result = new ArrayList<>();
        for (T element : input) {
            if (condition.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        Predicate<Integer> odd = x -> (x % 2) != 0;

        List<Integer> filtered = filter(numbers, odd);
        System.out.println(filtered); // [1, 3]
    }
}