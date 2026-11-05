package bookstore.exception;

/** Thrown when a book fails validation (blank id or title, non-positive price). */
public class InvalidBookException extends BookStoreException {
    public InvalidBookException(String message) {
        super(message);
    }
}
