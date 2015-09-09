package map2;

public class Square implements Imap<Integer> {
	public Integer apply(Integer elem) {
				return elem*elem;
	}
}
