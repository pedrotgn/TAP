package structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test2 {

	public static void main(String args[]) {
		List<String> c = new ArrayList<String>();

		String lista[] = { "uno", "dos", "tres", "cuatro" };

		for (String num : lista)
			c.add(num);

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