package bookstore.exception;

/** Thrown when an order asks for more copies than the stock. */
public class OutOfStockException extends BookStoreException {
    public OutOfStockException(String id, int requested, int available) {
        super("Not enough stock for " + id + ": requested " + requested + ", available " + available);
    }
}
