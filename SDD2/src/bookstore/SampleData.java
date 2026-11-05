package bookstore;

import bookstore.model.Book;
import bookstore.repository.InMemoryBookRepository;

/** A small catalogue used by the tests, the tools and the exercises. */
public final class SampleData {
    private SampleData() {
    }

    /**
     * Seven books, in this order (price in cents, stock):
     * b1 Don Quixote 1500/5, b2 Exemplary Novels 1200/2 (both Cervantes),
     * b3 1984 900/10, b4 Animal Farm 700/0 (both George Orwell),
     * b5 Hamlet 600/7, b6 Macbeth 650/3 (both William Shakespeare),
     * b7 Ulysses 2200/1 (James Joyce).
     */
    public static InMemoryBookRepository catalogue() {
        InMemoryBookRepository repository = new InMemoryBookRepository();
        repository.save(new Book("b1", "Don Quixote", "Cervantes", 1500, 5));
        repository.save(new Book("b2", "Exemplary Novels", "Cervantes", 1200, 2));
        repository.save(new Book("b3", "1984", "George Orwell", 900, 10));
        repository.save(new Book("b4", "Animal Farm", "George Orwell", 700, 0));
        repository.save(new Book("b5", "Hamlet", "William Shakespeare", 600, 7));
        repository.save(new Book("b6", "Macbeth", "William Shakespeare", 650, 3));
        repository.save(new Book("b7", "Ulysses", "James Joyce", 2200, 1));
        return repository;
    }
}
