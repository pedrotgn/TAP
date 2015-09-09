package farm;
public class Parrot extends Animal {

	public Parrot(int legs, int eyes) {
		super(legs, eyes);
	}

	// Refinement

	public String talk() {
		return "I am a parrot and " + super.talk();
	}
}
