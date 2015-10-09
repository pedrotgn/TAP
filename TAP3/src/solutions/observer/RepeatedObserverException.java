package solutions.observer;


public class RepeatedObserverException extends Exception {

	public RepeatedObserverException() {
		super();
	}

	public RepeatedObserverException(String message) {
		super(message);
	}

	public RepeatedObserverException(String message, Throwable cause) {
		super(message, cause);
	}

	public RepeatedObserverException(Throwable cause) {
		super(cause);
	}

}
