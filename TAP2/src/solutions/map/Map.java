package solutions.map;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Map {

    public static <T, U> List<U> map(List<T> list, Function<T, U> function) {
        List<U> result = new LinkedList<>();
        for (T elem : list)
            result.add(function.apply(elem));
        return result;
    }

}