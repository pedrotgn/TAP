package tools;

import bookstore.SampleData;
import bookstore.model.Book;
import bookstore.service.BookService;

/**
 * Starting point of exercise E2 (the bug of the reorder report).
 * Run with ./run.sh reproduce-lowstock
 */
public class ReproduceLowStock {
    public static void main(String[] args) {
        BookService service = new BookService(SampleData.catalogue());
        int threshold = 2;
        System.out.println("Stock of every book:");
        for (Book b : SampleData.catalogue().findAll()) {
            System.out.println("  " + b.getTitle() + " -> " + b.getStock());
        }
        System.out.println("findLowStock(" + threshold + ") -> ");
        for (Book b : service.findLowStock(threshold)) {
            System.out.println("  " + b.getTitle() + " (" + b.getStock() + ")");
        }
    }
}
