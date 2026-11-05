package bookstore.service;

import bookstore.exception.BookNotFoundException;
import bookstore.exception.InvalidBookException;
import bookstore.model.Book;
import bookstore.repository.InMemoryBookRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Convention for tests (see steering/by-file-type/tests.md):
 * one test class per class under test, same package,
 * method names follow method_condition_expectedResult.
 */
public class BookServiceTest {
    private BookService service;

    @Before
    public void setUp() {
        service = new BookService(new InMemoryBookRepository());
        service.addBook(new Book("b1", "Don Quixote", "Cervantes", 1500));
        service.addBook(new Book("b2", "Exemplary Novels", "Cervantes", 1200));
        service.addBook(new Book("b3", "1984", "George Orwell", 900));
    }

    @Test
    public void getBook_existingId_returnsBook() {
        Assert.assertEquals("Don Quixote", service.getBook("b1").getTitle());
    }

    @Test(expected = BookNotFoundException.class)
    public void getBook_unknownId_throwsBookNotFound() {
        service.getBook("zzz");
    }

    @Test(expected = InvalidBookException.class)
    public void addBook_zeroPrice_throwsInvalidBook() {
        service.addBook(new Book("b9", "Free book", "Nobody", 0));
    }

    @Test(expected = InvalidBookException.class)
    public void addBook_blankTitle_throwsInvalidBook() {
        service.addBook(new Book("b9", "  ", "Nobody", 500));
    }

    @Test
    public void listByAuthor_knownAuthor_returnsTheirBooks() {
        List<Book> books = service.listByAuthor("Cervantes");
        Assert.assertEquals(2, books.size());
    }

    @Test
    public void listByAuthor_unknownAuthor_returnsEmptyList() {
        Assert.assertTrue(service.listByAuthor("Nobody").isEmpty());
    }
}
