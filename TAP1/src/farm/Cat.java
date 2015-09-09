package farm;
public class Cat extends Animal {
	
	public Cat(int legs, int eyes) {
		super(legs, eyes);
	}

	// Inheritance with replacement method

	public String talk() {
		return "I'm a cat";
	}
}
