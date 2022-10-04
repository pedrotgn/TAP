package solutions.map3;

import java.util.LinkedList;
import java.util.List;

public class Map3 {
    public static <T, R> List<R> map(List<T> list, IMap3<T, R> function) {
        List<R> result = new LinkedList<R>();
        for (T elem : list)
            result.add(function.apply(elem));
        return result;

    }
}
