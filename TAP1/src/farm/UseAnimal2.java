package farm;
import java.util.LinkedList;

public class UseAnimal2 {

	public static void main(String[] args) {
		
		// Create animals
		Animal a = new Animal(3, 3);
		Cat g = new Cat(1, 2);
		MutantParrot lM = new MutantParrot(3, 3);

		// Static list
		Animal[] farm = new Animal[3];
		farm[0] = a;
		farm[1] = g;
		farm[2] = lM;

		for (Animal ani : farm)
			System.out.println(ani.talk());

		// Dynamic list
		LinkedList<Animal> lorry = new LinkedList<>();
		lorry.add(a);
		lorry.add(g);
		lorry.add(lM);

		// New for
		for (Animal o : lorry)
			System.out.println(o.talk());

	}

}
