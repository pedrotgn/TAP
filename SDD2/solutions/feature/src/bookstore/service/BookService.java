package bookstore.service;

import bookstore.exception.BookNotFoundException;
import bookstore.exception.InvalidQueryException;
import bookstore.model.Book;
import bookstore.repository.BookRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
            if (book.getStock() < threshold) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Books with a price between minCents and maxCents, both included, cheapest
     * first. Books with the same price are ordered by title.
     * Never null; empty when there are none.
     *
     * @throws InvalidQueryException if minCents is negative or greater than maxCents
     */
    public List<Book> findByPriceRange(long minCents, long maxCents) {
        if (minCents < 0) {
            throw new InvalidQueryException("Minimum price must not be negative: " + minCents);
        }
        if (minCents > maxCents) {
            throw new InvalidQueryException("Minimum price is greater than maximum: "
                    + minCents + " > " + maxCents);
        }
        List<Book> result = new ArrayList<>();
        for (Book book : repository.findAll()) {
            if (book.getPriceCents() >= minCents && book.getPriceCents() <= maxCents) {
                result.add(book);
            }
        }
        Collections.sort(result, new Comparator<Book>() {
            @Override
            public int compare(Book a, Book b) {
                int byPrice = Long.compare(a.getPriceCents(), b.getPriceCents());
                return byPrice != 0 ? byPrice : a.getTitle().compareTo(b.getTitle());
            }
        });
        return result;
    }
}
