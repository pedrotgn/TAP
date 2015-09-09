package stacks;
import java.util.Vector;

public class VectorStack implements Stack {

	private Vector<Integer> pile;
	private int size;
	private int cnt;

	/**
	 * Constructor stack type.
	 * 
	 * @param size
	 *            Specify size of stack
	 */

	public VectorStack(int size) {
		this.pile = new Vector<Integer>(size);
		this.size = size;
		this.cnt = 0;

	}

	@Override
	public void push(int elem) {
		pile.add(elem);
		cnt++;

	}

	@Override
	public int pop() {
		int elem = pile.lastElement();
		pile.remove(elem);
		cnt = cnt - 1;
		return elem;
	}

	@Override
	public boolean full() {
		return (size == cnt);
	}

	@Override
	public boolean empty() {
		return (cnt == 0);
	}

}
