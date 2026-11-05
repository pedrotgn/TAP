package bookstore.service;

import bookstore.SampleData;
import bookstore.exception.InvalidQueryException;
import bookstore.model.Book;
import bookstore.repository.InMemoryBookRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Acceptance criteria of the feature "search by price range".
 * These tests FAIL until the feature is implemented.
 *
 * Prices in the sample catalogue: Hamlet 600, Macbeth 650, Animal Farm 700,
 * 1984 900, Exemplary Novels 1200, Don Quixote 1500, Ulysses 2200.
 */
public class PriceRangeAcceptanceTest {
    private InMemoryBookRepository repository;
    private BookService service;

    @Before
    public void setUp() {
        repository = SampleData.catalogue();
        service = new BookService(repository);
    }

    private static String titles(List<Book> books) {
        StringBuilder sb = new StringBuilder();
        for (Book b : books) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(b.getTitle());
        }
        return sb.toString();
    }

    @Test
    public void bothLimitsAreInclusive_andResultIsCheapestFirst() {
        Assert.assertEquals("Hamlet, Macbeth, Animal Farm, 1984", titles(service.findByPriceRange(600, 900)));
    }

    @Test
    public void sameMinAndMax_returnsTheBooksWithExactlyThatPrice() {
        Assert.assertEquals("Macbeth", titles(service.findByPriceRange(650, 650)));
    }

    @Test
    public void samePrice_isOrderedByTitle() {
        repository.save(new Book("x1", "Beta", "Someone", 650, 1));
        repository.save(new Book("x2", "Alpha", "Someone", 650, 1));
        Assert.assertEquals("Alpha, Beta, Macbeth", titles(service.findByPriceRange(650, 650)));
    }

    @Test
    public void noBookInRange_returnsEmptyListNotNull() {
        List<Book> result = service.findByPriceRange(5000, 6000);
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
    }

    @Test
    public void zeroAsMinimum_isAllowed() {
        Assert.assertEquals(7, service.findByPriceRange(0, 100000).size());
    }

    @Test(expected = InvalidQueryException.class)
    public void minGreaterThanMax_throwsInvalidQuery() {
        service.findByPriceRange(900, 600);
    }

    @Test(expected = InvalidQueryException.class)
    public void negativeMin_throwsInvalidQuery() {
        service.findByPriceRange(-1, 600);
    }

    @Test
    public void search_doesNotChangeTheStock() {
        service.findByPriceRange(0, 100000);
        Assert.assertEquals(5, repository.findById("b1").get().getStock());
    }
}
