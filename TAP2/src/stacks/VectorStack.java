package stacks;

import java.util.Iterator;
import java.util.Vector;

public class VectorStack<T > implements Stack<T> {

	 private Vector<T> monton;
	 private int max; 
	 private int cnt;

	  /**
	   * Constructor del tipo pila. 
	   * @param tam Especifica el tama�o de la pila
	   */
	  public VectorStack(int max) {
	    this.monton = new Vector<T>();
	    this.max = max;
	    this.cnt = 0;
	 
	  }

	
	public void push(T elem) {
		monton.add(elem);
		cnt++;
	}

	public T pop() {
		T elem =  monton.lastElement();
		monton.remove(elem);
		cnt = cnt -1;
	    return elem;
	}

	public boolean full() {
		 return (max == cnt);
	}

	public boolean empty() {
		 return (cnt == 0);
	}


	public Iterator<T> iterator() {
		return monton.iterator();
	}


}
