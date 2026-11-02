package bookstore.repository;

import bookstore.model.Book;

import java.util.List;
import java.util.Optional;

/** Storage of books. A missing book is an empty Optional, never null. */
public interface BookRepository {
    Optional<Book> findById(String id);

    /** All books in insertion order. Returns a copy of the list. */
    List<Book> findAll();

    /** Inserts the book, or replaces the one with the same id. */
    void save(Book book);
}
