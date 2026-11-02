package bookstore.exception;

/** Thrown when an order is empty or has a line with a quantity that is not positive. */
public class InvalidOrderException extends BookStoreException {
    public InvalidOrderException(String message) {
        super(message);
    }
}
