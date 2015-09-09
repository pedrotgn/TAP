package stacks;

public class ArrayStack implements Stack {

	private int[] pile;
	private int top;

	/**
	 * Constructor stack type.
	 * 
	 * @param size
	 *            Specify size of stack
	 */

	public ArrayStack(int size) {
		pile = new int[size];
		top = 0;
	}

	@Override
	public void push(int elem) {
		pile[top] = elem;
		top++;

	}

	@Override
	public int pop() {
		top--;
		return pile[top];
	}

	@Override
	public boolean full() {
		return (top == pile.length);
	}

	@Override
	public boolean empty() {
		return (top == 0);
	}

}
