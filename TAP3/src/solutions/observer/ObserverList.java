package solutions.observer;



public interface ObserverList<T> extends Iterable<T> {
	
	void register(Observer<T> observer) throws RepeatedObserverException;
	void unregister(Observer<T> observer);

	void add(T elem);
	void remove(T elem);

}
