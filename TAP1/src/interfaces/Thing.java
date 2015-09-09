package interfaces;

public class Thing implements Musician, Bop {

	@Override
	public String dance() {
		return "LALALA";
	}

	@Override
	public String sing() {
		return "ouch...";
	}

}
