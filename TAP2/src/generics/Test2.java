package generics;

import java.util.Collection;
import java.util.LinkedList;

public class Test2 {

	public static void main(String[] args) {

		Animal a = new Animal(3, 3);
		Cat g = new Cat(1, 2);
		MutantParrot lM = new MutantParrot(3, 3);

		LinkedList<Animal> granja = new LinkedList<Animal>();
		granja.add(a);
		granja.add(g);
		granja.add(lM);
		test(granja);
		test2(granja);
		Cat p = getParam(g);

	}

	public static void test(Collection<? extends Animal> c) {
		for (Animal elem: c)
			System.out.println(elem.talk());
		
		System.out.println("-------------------------");
	}

	public static <T extends Animal> void test2(Collection<T> c) {
		for (Animal elem: c)
			System.out.println(elem.talk());
		
		System.out.println("-------------------------");
	}

	public static <T extends Animal> T getParam(T elem) {
		return elem;
	}

}
