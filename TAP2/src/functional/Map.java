package functional;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;


/**
 * Created by pedro on 9/2/14.
 */
public class Map {


    public static <T> List<T> map(List<T> list, Function<T,T> f) {
        List<T> result = new LinkedList<T>();
        for (T elem:list){
            result.add(f.apply(elem));
        }
        return result;
    }

    public static void main(String args[]){
        List<String> elems = new LinkedList<>();
        elems.add("tap");
        elems.add("lp");
        List <String> result = Map.map(elems, (String p) -> p.toUpperCase());
        for (String elem:result)
            System.out.println(elem);

    }
}
