package structures;

import java.util.Comparator;

public class NameComparator implements Comparator<Client> {

	public int compare(Client p1, Client p2) {

		String s1 = p1.getName();
		String s2 = p2.getName();

		return (s1.compareTo(s2));
	}

}