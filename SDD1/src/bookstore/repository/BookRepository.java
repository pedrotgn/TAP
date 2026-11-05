package bookstore.repository;

import bookstore.model.Book;

import java.util.List;
import java.util.Optional;

/** Storage of books. A missing book is an empty Optional, never null. */
public interface BookRepository {
    Optional<Book> findById(String id);

    List<Book> findAll();

    void save(Book book);
}
