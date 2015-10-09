package solutions.observer;


public interface Observer<T> {

	void notifyAdd(T elem);
	void notifyRemove(T elem);

}
