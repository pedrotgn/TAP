package map2;

public class Capitals implements Imap<String> {

	public String apply(String elem) {
		return elem.toUpperCase();
	}

}
