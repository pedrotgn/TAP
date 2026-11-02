package bookstore.service;

import bookstore.SampleData;
import bookstore.exception.BookNotFoundException;
import bookstore.exception.InvalidOrderException;
import bookstore.exception.OutOfStockException;
import bookstore.model.Book;
import bookstore.model.OrderLine;
import bookstore.model.Receipt;
import bookstore.repository.InMemoryBookRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Characterization tests: they describe what quote() and checkout() do TODAY.
 * They are the "invariant" of a refactoring spec: after the change, they must
 * pass without being modified.
 *
 * Not pinned on purpose: an order with two lines for the same book.
 */
public class OrderServiceCharacterizationTest {
    private InMemoryBookRepository repository;
    private OrderService service;

    @Before
    public void setUp() {
        repository = SampleData.catalogue();
        service = new OrderService(repository);
    }

    private static List<OrderLine> lines(OrderLine... lines) {
        return Arrays.asList(lines);
    }

    // ---- checkout: prices

    @Test
    public void checkout_fewerThanFiveUnits_hasNoDiscount() {
        Receipt r = service.checkout(lines(new OrderLine("b1", 2), new OrderLine("b3", 1)));
        Assert.assertEquals(new Receipt(3900, 0, 3900), r);
    }

    @Test
    public void checkout_fiveUnits_gets10PercentOff() {
        Receipt r = service.checkout(lines(new OrderLine("b1", 3), new OrderLine("b3", 2)));
        Assert.assertEquals(new Receipt(6300, 630, 5670), r);
    }

    @Test
    public void checkout_discountIsRoundedDown() {
        repository.save(new Book("odd", "Odd price", "Someone", 333, 10));
        Receipt r = service.checkout(lines(new OrderLine("odd", 5)));
        Assert.assertEquals(new Receipt(1665, 166, 1499), r);
    }

    // ---- checkout: stock

    @Test
    public void checkout_takesTheCopiesOutOfTheStock() {
        service.checkout(lines(new OrderLine("b1", 3), new OrderLine("b3", 2)));
        Assert.assertEquals(2, repository.findById("b1").get().getStock());
        Assert.assertEquals(8, repository.findById("b3").get().getStock());
    }

    @Test
    public void checkout_canTakeAllTheStock() {
        service.checkout(lines(new OrderLine("b7", 1)));
        Assert.assertEquals(0, repository.findById("b7").get().getStock());
    }

    @Test
    public void checkout_notEnoughStock_throwsAndChangesNothing() {
        try {
            service.checkout(lines(new OrderLine("b1", 1), new OrderLine("b2", 3)));
            Assert.fail("expected OutOfStockException");
        } catch (OutOfStockException expected) {
            Assert.assertEquals(5, repository.findById("b1").get().getStock());
            Assert.assertEquals(2, repository.findById("b2").get().getStock());
        }
    }

    // ---- checkout: invalid orders

    @Test(expected = InvalidOrderException.class)
    public void checkout_nullOrder_throwsInvalidOrder() {
        service.checkout(null);
    }

    @Test(expected = InvalidOrderException.class)
    public void checkout_emptyOrder_throwsInvalidOrder() {
        service.checkout(Collections.<OrderLine>emptyList());
    }

    @Test(expected = InvalidOrderException.class)
    public void checkout_zeroQuantity_throwsInvalidOrder() {
        service.checkout(lines(new OrderLine("b1", 0)));
    }

    @Test(expected = BookNotFoundException.class)
    public void checkout_unknownBook_throwsBookNotFound() {
        service.checkout(lines(new OrderLine("zzz", 1)));
    }

    // ---- quote

    @Test
    public void quote_givesTheSameReceiptAsCheckout() {
        List<OrderLine> order = lines(new OrderLine("b1", 3), new OrderLine("b3", 2));
        Receipt quoted = service.quote(order);
        Receipt checked = new OrderService(SampleData.catalogue()).checkout(order);
        Assert.assertEquals(checked, quoted);
    }

    @Test
    public void quote_doesNotChangeTheStock() {
        service.quote(lines(new OrderLine("b1", 3)));
        Assert.assertEquals(5, repository.findById("b1").get().getStock());
    }

    @Test
    public void quote_ignoresTheStock() {
        Receipt r = service.quote(lines(new OrderLine("b4", 2)));
        Assert.assertEquals(new Receipt(1400, 0, 1400), r);
    }

    @Test(expected = BookNotFoundException.class)
    public void quote_unknownBook_throwsBookNotFound() {
        service.quote(lines(new OrderLine("zzz", 1)));
    }

    @Test(expected = InvalidOrderException.class)
    public void quote_emptyOrder_throwsInvalidOrder() {
        service.quote(Collections.<OrderLine>emptyList());
    }

    @Test(expected = InvalidOrderException.class)
    public void quote_negativeQuantity_throwsInvalidOrder() {
        service.quote(lines(new OrderLine("b1", -1)));
    }
}
