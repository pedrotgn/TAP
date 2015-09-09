package farm;
public class Dog extends Animal {
	
	private boolean fleas; // Own attribute

	public Dog(int legs, int eyes, boolean fleas) {
		super(legs, eyes);
		this.fleas = fleas;
	}

	public void setFleas(boolean fleas) {
		this.fleas = fleas;
	}

	public boolean getFleas() {
		return fleas;
	}

	// change attributes
	public void changeFather() {
		this.legs = 3;
		// this.eyes = 2;
		setLegs(4);
		setEyes(5);
	}

	// Overwrite father's method
	public String talk() {
		return ("Fleas " + fleas);
	}
}
