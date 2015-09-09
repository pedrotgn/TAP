package stacks;

import java.util.Iterator;

public class ArrayStack<T> implements Stack<T>,Iterator<T> {

	 private T[] monton;
	 private int cima;
	 
	 int cnt = 0;
	 	 

	  /**
	   * Constructor del tipo pila. 
	   * @param tam Especifica el tama�o de la pila
	   */
	  public ArrayStack(T[]lista) {
	    monton = lista;
	    cima = 0;
	  }

	
	public void push(T elem) {
		 monton[cima] = elem;
		 cima++;
	}

	public T pop() {
		cima--;
	    return monton[cima];
	}

	public boolean full() {
		 return (cima == monton.length);
	}

	public boolean empty() {
		 return (cima == 0);
	}


	public Iterator<T> iterator() {
		return this;
	}


	public boolean hasNext() {
		return (cnt <cima);
	}


	public T next() {
		System.out.println("avanza");
		cnt = cnt +1;
		return monton[cnt-1];
	}


	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
