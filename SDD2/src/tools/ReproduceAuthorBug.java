package tools;

import bookstore.SampleData;
import bookstore.service.BookService;

/**
 * Reproduction of the bug used as the worked example in class:
 * "searching by author is case sensitive".
 * Run with ./run.sh reproduce-author
 */
public class ReproduceAuthorBug {
    public static void main(String[] args) {
        BookService service = new BookService(SampleData.catalogue());
        System.out.println("findByAuthor(\"Cervantes\") -> " + service.findByAuthor("Cervantes").size() + " book(s)");
        System.out.println("findByAuthor(\"cervantes\") -> " + service.findByAuthor("cervantes").size() + " book(s)");
        System.out.println("Expected: both return the same books.");
    }
}
