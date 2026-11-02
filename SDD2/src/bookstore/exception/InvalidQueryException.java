package bookstore.exception;

/** Thrown when the arguments of a search make no sense (for example, an inverted range). */
public class InvalidQueryException extends BookStoreException {
    public InvalidQueryException(String message) {
        super(message);
    }
}
