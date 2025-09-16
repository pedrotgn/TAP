package solutions.structures;

import java.util.Comparator;

public class AgeComparator implements Comparator<Client> {
	public int compare(Client p1, Client p2) {
		int age1 = p1.getAge();
		int age2 = p2.getAge();
		return Integer.compare(age1,age2);
	}
}