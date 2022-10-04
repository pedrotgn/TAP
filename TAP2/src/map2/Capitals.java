package map2;

public class Capitals implements IMap<String> {

	public String apply(String elem) {
		return elem.toUpperCase();
	}

}
