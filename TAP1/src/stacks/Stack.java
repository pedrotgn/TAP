package stacks;
public interface Stack {
	/**
	 * Introduce an element at the top
	 * 
	 * @param elem
	 *            Item to add at the top oh the stack.
	 */
	public void push(int elem);

	/**
	 * Obtain element that's on the top and delete it
	 */
	public int pop();

	/**
	 * Say if stack is full.
	 */
	public boolean full();

	/**
	 * Say if stack is empty.
	 */
	public boolean empty();
}
