package solutions.bstree;
import java.util.Comparator;

public class Comparaint implements Comparator<Integer> {

	public int compare(Integer arg0, Integer arg1) {
		if (arg0<=arg1)
			return -1;
		else
			return 1;
			
	}

}
