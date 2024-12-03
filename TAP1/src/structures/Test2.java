package structures;

import java.util.*;

public class Test2 {

	public static void main(String[] args) {


		String[] list = { "uno", "dos", "tres", "cuatro" };

		List<String> c = Arrays.asList(list);


		print(c);

		Collections.sort(c);

		print(c);

		int loc = Collections.binarySearch(c, "dos");
		System.out.println("Posicion de " + "dos" + " = " + loc);

	}

	public static void print(Collection<String> c) {
		
		for(String num:c)
			System.out.println(num);
		
		System.out.println("-------------------------");
	}

}