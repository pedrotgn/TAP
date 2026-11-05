package tools;

import bookstore.model.Book;
import bookstore.model.OrderLine;
import bookstore.model.Receipt;
import bookstore.repository.InMemoryBookRepository;
import bookstore.service.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 * Measures the cost of OrderService.quote with the metric of exercise E4:
 * the number of books the repository has had to look at.
 * Run with ./run.sh perf
 */
public class PerfCheck {
    public static void main(String[] args) {
        int catalogueSize = 1000;
        int lineCount = 20;

        InMemoryBookRepository repository = new InMemoryBookRepository();
        for (int i = 0; i < catalogueSize; i++) {
            repository.save(new Book("g" + i, "Title " + i, "Author " + (i % 50), 500 + i, 10));
        }
        List<OrderLine> lines = new ArrayList<>();
        for (int i = 0; i < lineCount; i++) {
            lines.add(new OrderLine("g" + (i * 37 % catalogueSize), 1));
        }

        OrderService service = new OrderService(repository);
        repository.resetScannedCount();
        Receipt receipt = service.quote(lines);

        System.out.println("Catalogue: " + catalogueSize + " books, order: " + lineCount + " lines");
        System.out.println("Receipt: " + receipt);
        System.out.println("Books scanned by the repository: " + repository.getScannedCount());
    }
}
