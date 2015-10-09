package solutions.observer;



import java.util.Vector;


public class BackupObserver<T> implements Observer<T> {
	private Vector<T> backup;
	
	
	public BackupObserver() {
		backup = new Vector<T>();
	}
	

	public void notifyAdd(T elem) {
		backup.add(elem);
	}

	public void notifyRemove(T elem) {
		backup.remove(elem);
	}

	public boolean equals(Object obj) {
		return this.getClass().getCanonicalName().equals(obj.getClass().getCanonicalName());
	}


	public String toString() {
		return this.getClass().getName();
	}

}
