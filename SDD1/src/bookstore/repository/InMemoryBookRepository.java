package bookstore.repository;

import bookstore.model.Book;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/** Repository kept in memory. Books are listed in insertion order. */
public class InMemoryBookRepository implements BookRepository {
    private final Map<String, Book> books = new LinkedHashMap<>();

    @Override
    public Optional<Book> findById(String id) {
        return Optional.ofNullable(books.get(id));
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    @Override
    public void save(Book book) {
        books.put(book.getId(), book);
    }
}
