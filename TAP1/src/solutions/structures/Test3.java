package solutions.structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Test3 {

	public static void print(Collection<Client> c) {
		for (Client p : c) {
			System.out.println("name:" + p.getName() + "  age:" + p.getAge());
		}
		System.out.println("-------------------------");
	}

	public static void main(String[] args) {
		Client p1 = new Client("jose", 30);
		Client p2 = new Client("pedro", 24);
		Client p3 = new Client("jcarlos", 100);

		List<Client> c = new ArrayList<>();
		c.add(p1);
		c.add(p2);
		c.add(p3);

		System.out.println("-No ordering---------------");
		print(c);

		NameComparator t1 = new NameComparator();
		c.sort(t1);
		//Collections.sort(c, t1);
		System.out.println("-Ordered by name--------");
		print(c);

		AgeComparator t2 = new AgeComparator();
		c.sort(t2);
		System.out.println("-Ordered by age--------");
		print(c);

        Collections.sort(c);
        System.out.println("-Using Client.compare--------");
        print(c);

	}
}