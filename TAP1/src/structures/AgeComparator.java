package structures;

import java.util.Comparator;

public class AgeComparator implements Comparator<Client> {
	
	public int compare(Client p1, Client p2) {

		int s1 = p1.getAge();
		int s2 = p2.getAge();

		if (s1 > s2)
			return 1;
		else if (s1 < s2)
			return -1;
		else
			return 0;
	}

}