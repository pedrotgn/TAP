package bookstore.exception;

/** Thrown when a book id does not exist in the catalogue. */
public class BookNotFoundException extends BookStoreException {
    public BookNotFoundException(String id) {
        super("Book not found: " + id);
    }
}
