package solutions.observer;



import java.util.Iterator;
import java.util.Vector;


public class ObserverListImpl<T> implements ObserverList<T> {
	Vector<Observer<T>> observers;
	Vector<T> content;
	
	public ObserverListImpl() {
		observers = new Vector<Observer<T>>();
		content = new Vector<T>();
	}
	

	public void register(Observer<T> observer) throws RepeatedObserverException {
		if (observers.contains(observer))
			throw new RepeatedObserverException("Observer '"+observer+"' already exists!");
		observers.add(observer);
	}

	public void unregister(Observer<T> observer) {
		observers.remove(observer);
	}

	public void add(T elem) {
		content.add(elem);
		notifyAllAdd(elem);
	}

	public void remove(T elem) {
		content.remove(elem);
		notifyAllRemove(elem);
	}
	

	protected void notifyAllAdd(T elem) {
		for (Observer<T> ob:observers)
			ob.notifyAdd(elem);
	}
	
	protected void notifyAllRemove(T elem) {
		for (Observer<T> ob:observers)
			ob.notifyRemove(elem);
	}

	public Iterator<T> iterator() {
		return content.iterator();
	}

}
