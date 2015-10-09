package solutions.observer;




public class PrinterObserver<T> implements Observer<T> {


	public void notifyAdd(T elem) {
		System.out.println("ADDED: "+elem);
	}

	public void notifyRemove(T elem) {
		System.out.println("REMOVED: "+elem);
	}

	public boolean equals(Object obj) {
		return this.getClass().getCanonicalName().equals(obj.getClass().getCanonicalName());
	}

	public String toString() {
		return this.getClass().getName();
	}
	
}
