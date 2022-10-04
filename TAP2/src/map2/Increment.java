package map2;

public class Increment implements IMap<Integer> {
	public Integer apply(Integer elem) {

		return elem+1;
	}
}
