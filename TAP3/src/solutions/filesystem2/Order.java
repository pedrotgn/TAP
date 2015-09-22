package solutions.filesystem2;

import java.util.Comparator;

public class Order implements Comparator<AComponent> {

	public int compare(AComponent arg0, AComponent arg1) {
		// TODO Auto-generated method stub
		return arg0.getName().compareTo(arg1.getName());
	}

}
