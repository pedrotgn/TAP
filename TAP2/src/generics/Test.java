package generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Test {

	public static void main(String args[]) {
		Collection<String> c;
		String lista[] = { "uno", "dos", "tres", "cuatro", "tres" };

		c = new ArrayList<String>();
		for (int i = 0; i < lista.length; i++)
			c.add(lista[i]);
		test(c);
	   // test2(c); //ES ILEGAL !!!!
		test3(c);

	}

	public static <T> void test(Collection<T> c) {

		// String lista[] = {"uno", "dos" , "tres", "cuatro", "tres"};

		// for( int i=0; i < lista.length; i++ )
		// c.add( lista[i] ); //ILEGAL !!

		for (T elem : c) {
			System.out.println(elem);
		}

		System.out.println("-------------------------");
	}

	public static void test2(Collection<Object> c) {
		for (Object elem : c)
			System.out.println(elem);

		System.out.println("-------------------------");
	}

	public static void test3(Collection<?> c) {
		Iterator<?> it = c.iterator();

		while (it.hasNext())
			System.out.println(it.next());

		System.out.println("-------------------------");
	}

}