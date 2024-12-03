package solutions.observer;


 interface Observer<T> {

	void notifyAdd(T elem);
	void notifyRemove(T elem);

}
