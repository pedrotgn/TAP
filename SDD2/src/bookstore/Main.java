package bookstore;

import bookstore.model.OrderLine;
import bookstore.repository.InMemoryBookRepository;
import bookstore.service.BookService;
import bookstore.service.OrderService;

import java.util.Arrays;

/** Small demo. Only Main, tools and tests may print to System.out. */
public class Main {
    public static void main(String[] args) {
        InMemoryBookRepository repository = SampleData.catalogue();
        BookService books = new BookService(repository);
        OrderService orders = new OrderService(repository);

        System.out.println("Cervantes: " + books.findByAuthor("Cervantes"));
        System.out.println("Quote: " + orders.quote(Arrays.asList(
                new OrderLine("b1", 3), new OrderLine("b3", 2))));
        System.out.println("Checkout: " + orders.checkout(Arrays.asList(
                new OrderLine("b1", 3), new OrderLine("b3", 2))));
        System.out.println("Stock of b1 after checkout: " + books.getBook("b1").getStock());
    }
}
