package bookstore.exception;

/** Base class of every domain error of the bookstore. Unchecked. */
public class BookStoreException extends RuntimeException {
    public BookStoreException(String message) {
        super(message);
    }
}
