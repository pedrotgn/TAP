package bookstore.model;

import java.util.Objects;

/**
 * A book in the catalogue. Prices are stored in cents (a long), never as a double.
 * Title, author and price do not change; only the stock does.
 */
public final class Book {
    private final String id;
    private final String title;
    private final String author;
    private final long priceCents;
    private int stock;

    public Book(String id, String title, String author, long priceCents, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.priceCents = priceCents;
        this.stock = stock;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getPriceCents() {
        return priceCents;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        return id.equals(((Book) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title=" + title + ", author=" + author
                + ", priceCents=" + priceCents + ", stock=" + stock + "}";
    }
}
