package bookstore.service;

import bookstore.model.Book;
import bookstore.model.OrderLine;
import bookstore.model.Receipt;
import bookstore.repository.InMemoryBookRepository;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Acceptance criteria of the performance task on OrderService.quote.
 * The metric is the number of books the repository has to look at.
 * The scanned-count test FAILS until quote is improved.
 */
public class QuotePerformanceAcceptanceTest {
    private static final int CATALOGUE_SIZE = 500;
    private static final int LINES = 10;

    private InMemoryBookRepository bigCatalogue() {
        InMemoryBookRepository repository = new InMemoryBookRepository();
        for (int i = 0; i < CATALOGUE_SIZE; i++) {
            repository.save(new Book("g" + i, "Title " + i, "Author", 1000 + i, 10));
        }
        return repository;
    }

    private List<OrderLine> order() {
        List<OrderLine> lines = new ArrayList<>();
        for (int i = 0; i < LINES; i++) {
            lines.add(new OrderLine("g" + (i * 41), 1));
        }
        return lines;
    }

    @Test
    public void quote_looksAtMostOneBookPerLine() {
        InMemoryBookRepository repository = bigCatalogue();
        OrderService service = new OrderService(repository);
        repository.resetScannedCount();

        service.quote(order());

        long scanned = repository.getScannedCount();
        Assert.assertTrue("scanned " + scanned + " books, expected at most " + LINES,
                scanned <= LINES);
    }

    @Test
    public void quote_stillGivesTheSameReceipt() {
        // Lines g0, g41, g82, ... g369: prices 1000 + i, ten units in total, 10% off.
        long subtotal = 0;
        for (int i = 0; i < LINES; i++) {
            subtotal += 1000 + i * 41;
        }
        long discount = subtotal / 10;

        Receipt receipt = new OrderService(bigCatalogue()).quote(order());

        Assert.assertEquals(new Receipt(subtotal, discount, subtotal - discount), receipt);
    }
}
