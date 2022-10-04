package map2;


import java.util.LinkedList;
import java.util.List;

public class Map {

    public static <T> List<T> map(List<T> list, IMap<T> function) {
        List<T> result = new LinkedList<T>();
        for (T elem : list)
            result.add(function.apply(elem));
        return result;

    }

}
