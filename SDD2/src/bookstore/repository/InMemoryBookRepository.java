package bookstore.repository;

import bookstore.model.Book;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Repository kept in memory. Besides storing books, it counts how many books it
 * has had to look at (see getScannedCount). This gives a stable metric for the
 * performance exercise, much better than measuring milliseconds.
 */
public class InMemoryBookRepository implements BookRepository {
    private final Map<String, Book> books = new LinkedHashMap<>();
    private long scanned = 0;

    @Override
    public Optional<Book> findById(String id) {
        scanned += 1;
        return Optional.ofNullable(books.get(id));
    }

    @Override
    public List<Book> findAll() {
        scanned += books.size();
        return new ArrayList<>(books.values());
    }

    @Override
    public void save(Book book) {
        books.put(book.getId(), book);
    }

    /** Number of books looked at by findById/findAll since the last reset. */
    public long getScannedCount() {
        return scanned;
    }

    public void resetScannedCount() {
        scanned = 0;
    }
}
