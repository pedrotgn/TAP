package bookstore.service;

import bookstore.exception.BookNotFoundException;
import bookstore.exception.InvalidBookException;
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

    /** @throws InvalidBookException if the id or title is blank or the price is not positive */
    public void addBook(Book book) {
        if (book.getId() == null || book.getId().trim().isEmpty()) {
            throw new InvalidBookException("Book id must not be blank");
        }
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new InvalidBookException("Book title must not be blank");
        }
        if (book.getPriceCents() <= 0) {
            throw new InvalidBookException("Book price must be positive");
        }
        repository.save(book);
    }

    /** Books written by exactly this author. Never null; empty when there are none. */
    public List<Book> listByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : repository.findAll()) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }
}
