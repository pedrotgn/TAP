package bookstore;

import bookstore.exception.BookNotFoundException;
import bookstore.model.Book;
import bookstore.repository.InMemoryBookRepository;
import bookstore.service.BookService;

/** Small demo. Only Main (and tests) may print to System.out. */
public class Main {
    public static void main(String[] args) {
        BookService service = new BookService(new InMemoryBookRepository());
        service.addBook(new Book("b1", "Don Quixote", "Cervantes", 1500));
        service.addBook(new Book("b2", "Exemplary Novels", "Cervantes", 1200));
        service.addBook(new Book("b3", "1984", "George Orwell", 900));

        System.out.println("Cervantes: " + service.listByAuthor("Cervantes"));
        System.out.println("Unknown author: " + service.listByAuthor("Nobody"));

        try {
            service.getBook("zzz");
        } catch (BookNotFoundException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}
