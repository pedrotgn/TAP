package bookstore.service;

import bookstore.exception.BookNotFoundException;
import bookstore.exception.InvalidOrderException;
import bookstore.exception.OutOfStockException;
import bookstore.model.Book;
import bookstore.model.OrderLine;
import bookstore.model.Receipt;
import bookstore.repository.BookRepository;

import java.util.List;
import java.util.Optional;

/** Pricing and checkout of orders. */
public class OrderService {
    private final BookRepository repository;

    public OrderService(BookRepository repository) {
        this.repository = repository;
    }

    /**
     * Prices an order without changing the stock. It does not check the stock.
     * An order of 5 or more units in total gets 10% off the subtotal (rounded down).
     */
    public Receipt quote(List<OrderLine> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new InvalidOrderException("Order must have at least one line");
        }
        long subtotal = 0;
        int units = 0;
        for (OrderLine line : lines) {
            if (line.getQuantity() <= 0) {
                throw new InvalidOrderException("Quantity must be positive: " + line.getBookId());
            }
            Book found = null;
            for (Book b : repository.findAll()) {
                if (b.getId().equals(line.getBookId())) {
                    found = b;
                    break;
                }
            }
            if (found == null) {
                throw new BookNotFoundException(line.getBookId());
            }
            subtotal += found.getPriceCents() * line.getQuantity();
            units += line.getQuantity();
        }
        long discount = 0;
        if (units >= 5) {
            discount = subtotal / 10;
        }
        return new Receipt(subtotal, discount, subtotal - discount);
    }

    /**
     * Validates the order, prices it and takes the copies out of the stock.
     * If any line is wrong, nothing is changed.
     */
    public Receipt checkout(List<OrderLine> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new InvalidOrderException("Order must have at least one line");
        }
        long subtotal = 0;
        int units = 0;
        for (OrderLine line : lines) {
            if (line.getQuantity() <= 0) {
                throw new InvalidOrderException("Quantity must be positive: " + line.getBookId());
            }
            Optional<Book> book = repository.findById(line.getBookId());
            if (!book.isPresent()) {
                throw new BookNotFoundException(line.getBookId());
            }
            if (book.get().getStock() < line.getQuantity()) {
                throw new OutOfStockException(line.getBookId(), line.getQuantity(), book.get().getStock());
            }
        }
        for (OrderLine line : lines) {
            Book book = repository.findById(line.getBookId()).get();
            subtotal += book.getPriceCents() * line.getQuantity();
            units += line.getQuantity();
        }
        long discount = 0;
        if (units >= 5) {
            discount = subtotal / 10;
        }
        long total = subtotal - discount;
        for (OrderLine line : lines) {
            Book book = repository.findById(line.getBookId()).get();
            book.setStock(book.getStock() - line.getQuantity());
            repository.save(book);
        }
        return new Receipt(subtotal, discount, total);
    }
}
