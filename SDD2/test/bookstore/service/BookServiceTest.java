package bookstore.service;

import bookstore.SampleData;
import bookstore.exception.BookNotFoundException;
import bookstore.model.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Tests that pass today. They are the "no regression" part of the specs:
 * what already works and must keep working after any change.
 */
public class BookServiceTest {
    private BookService service;

    @Before
    public void setUp() {
        service = new BookService(SampleData.catalogue());
    }

    @Test
    public void getBook_existingId_returnsBook() {
        Assert.assertEquals("Don Quixote", service.getBook("b1").getTitle());
    }

    @Test(expected = BookNotFoundException.class)
    public void getBook_unknownId_throwsBookNotFound() {
        service.getBook("zzz");
    }

    @Test
    public void findByAuthor_exactName_returnsTheirBooksInCatalogueOrder() {
        List<Book> books = service.findByAuthor("Cervantes");
        Assert.assertEquals(2, books.size());
        Assert.assertEquals("Don Quixote", books.get(0).getTitle());
        Assert.assertEquals("Exemplary Novels", books.get(1).getTitle());
    }

    @Test
    public void findByAuthor_unknownAuthor_returnsEmptyList() {
        Assert.assertTrue(service.findByAuthor("Nobody").isEmpty());
    }

    @Test
    public void findLowStock_negativeThreshold_returnsEmptyList() {
        Assert.assertTrue(service.findLowStock(-1).isEmpty());
    }

    @Test
    public void findLowStock_hugeThreshold_returnsEveryBook() {
        Assert.assertEquals(7, service.findLowStock(1000).size());
    }
}
