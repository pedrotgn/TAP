package bookstore.service;

import bookstore.SampleData;
import bookstore.model.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Acceptance criteria of the bug in the reorder report: books whose stock is
 * exactly the threshold are missing. These tests FAIL until the bug is fixed.
 */
public class LowStockAcceptanceTest {
    private BookService service;

    @Before
    public void setUp() {
        service = new BookService(SampleData.catalogue());
    }

    private static String ids(List<Book> books) {
        StringBuilder sb = new StringBuilder();
        for (Book b : books) {
            sb.append(b.getId()).append(" ");
        }
        return sb.toString().trim();
    }

    @Test
    public void stockEqualToThreshold_isIncluded() {
        // stock: b2 = 2, b4 = 0, b7 = 1
        Assert.assertEquals("b2 b4 b7", ids(service.findLowStock(2)));
    }

    @Test
    public void thresholdZero_returnsTheBooksWithNoStock() {
        Assert.assertEquals("b4", ids(service.findLowStock(0)));
    }

    @Test
    public void resultKeepsCatalogueOrder() {
        Assert.assertEquals("b1 b2 b4 b6 b7", ids(service.findLowStock(5)));
    }

    @Test
    public void negativeThreshold_stillReturnsEmptyList() {
        Assert.assertTrue(service.findLowStock(-1).isEmpty());
    }
}
