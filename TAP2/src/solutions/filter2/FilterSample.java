package solutions.filter2;

import java.util.Arrays;
import java.util.List;

public class FilterSample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6);
		List<String> list2 = Arrays.asList("pedro", "lenguajes", "programacion", "Java", "Haskell");

		List<Integer> result = Filter.filter(list, new IsOdd());
		for (Integer elem: result)
			System.out.println(elem);

		List<String> result2 = Filter.filter(list2, new StartsWithCapital());
		for (String elem: result2)
			System.out.println(elem);

		

	}

}
