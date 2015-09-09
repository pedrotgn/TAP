package map2;


import java.util.Arrays;
import java.util.List;

public class MapSample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 3, 5, 7, 9);
		List<String> list2 = Arrays.asList("pedro", "lenguajes", "programacion", "Java", "haskell");


		List<Integer> result  = Map.map(list, new Increment());
		for (Integer elem:result)
			System.out.println(elem);

		result  = Map.map(list, new Square());
		for (Integer elem:result)
			System.out.println(elem);


		List<String> result2 = Map.map(list2, new Capitals());
		for (String elem:result2)
			System.out.println(elem);
		

	}

}
