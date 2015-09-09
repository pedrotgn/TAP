package farm;
public class UseAnimal {

	public static void main(String[] args) {
		Animal a = new Animal(3, 3);
		Dog p = new Dog(1, 1, true);
		Cat g = new Cat(1, 2);
		Parrot l = new Parrot(1, 2);
		MutantParrot lM = new MutantParrot(3, 3);

		System.out.println("ANIMAL: " + a.talk());
		System.out.println("DOG: " + p.talk());
		System.out.println("CAT: " + g.talk());
		System.out.println("PARROT: " + l.talk());
		System.out.println("MUTANT PARROT:" + lM.talk());

		a = p;
		System.out.println("ANIMAL: " + a.talk());

		a = lM;
		System.out.println("ANIMAL: " + a.talk());

	}

}
