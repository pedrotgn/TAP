package solutions.filter2;


import java.util.LinkedList;
import java.util.List;

public class Filter {

    public static <T> List<T> filter(List<T> list, IFilter<T> function) {
        List<T> result = new LinkedList<T>();
        for (T elem : list)
            if (function.apply(elem))
                result.add(elem);
        return result;
    }

}
