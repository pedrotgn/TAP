package legacy;

import bookstore.model.Book;

import java.util.List;

/**
 * Old code inherited from a previous project. It "works", but it does not
 * follow the conventions of the new bookstore package.
 * Exercise 2: decide what must NOT be copied into the steering file.
 */
public class PriceCalc {
    public static Object cache;
    public double price = 0;
    public double discountPercent = 10;

    public Book findBook(List<Book> books, String title) {
        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                return b;
            }
        }
        return null;
    }

    public double finalPrice(double base) {
        try {
            System.out.println("calculating price for " + base);
            return base - base * discountPercent / 100;
        } catch (Exception e) {
            return 0;
        }
    }
}
