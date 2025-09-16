package solutions.structures;

import java.util.Comparator;

public class NameComparator implements Comparator<Client> {
	public int compare(Client p1, Client p2) {
		String name1 = p1.getName();
		String name2 = p2.getName();
		return name1.compareTo(name2);
	}
}