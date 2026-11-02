package bookstore.model;

/** One line of an order: a book id and how many copies. */
public final class OrderLine {
    private final String bookId;
    private final int quantity;

    public OrderLine(String bookId, int quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public String getBookId() {
        return bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "OrderLine{bookId=" + bookId + ", quantity=" + quantity + "}";
    }
}
