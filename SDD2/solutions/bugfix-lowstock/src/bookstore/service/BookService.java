package bookstore.service;

import bookstore.exception.BookNotFoundException;
import bookstore.model.Book;
import bookstore.repository.BookRepository;

import java.util.ArrayList;
import java.util.List;

/** Business rules about books. Collaborators arrive through the constructor. */
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    /** @throws BookNotFoundException if there is no book with that id */
    public Book getBook(String id) {
        return repository.findById(id).orElseThrow(() -> new BookNotFoundException(id));
    }

    /** Books written by this author. Never null; empty when there are none. */
    public List<Book> findByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : repository.findAll()) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Books whose stock is at or below the threshold, in catalogue order.
     * Used by the weekly "what do we need to reorder" report.
     */
    public List<Book> findLowStock(int threshold) {
        List<Book> result = new ArrayList<>();
        for (Book book : repository.findAll()) {
            if (book.getStock() <= threshold) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Books with a price between minCents and maxCents.
     * TODO: not implemented yet. See specs/exercises/E3-feature-price-range.md
     */
    public List<Book> findByPriceRange(long minCents, long maxCents) {
        throw new UnsupportedOperationException("TODO: findByPriceRange");
    }
}
