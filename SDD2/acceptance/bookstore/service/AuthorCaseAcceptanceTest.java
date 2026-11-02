package bookstore.service;

import bookstore.SampleData;
import bookstore.model.Book;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Acceptance criteria of the bug "searching by author is case sensitive".
 * These tests FAIL until the bug is fixed.
 */
public class AuthorCaseAcceptanceTest {
    private BookService service;

    @Before
    public void setUp() {
        service = new BookService(SampleData.catalogue());
    }

    private static String titles(List<Book> books) {
        StringBuilder sb = new StringBuilder();
        for (Book b : books) {
            sb.append(b.getTitle()).append(";");
        }
        return sb.toString();
    }

    @Test
    public void lowerCaseAuthor_returnsTheSameBooksAsExactName() {
        Assert.assertEquals(titles(service.findByAuthor("Cervantes")),
                titles(service.findByAuthor("cervantes")));
        Assert.assertEquals(2, service.findByAuthor("cervantes").size());
    }

    @Test
    public void upperCaseAuthor_returnsTheSameBooksAsExactName() {
        Assert.assertEquals(2, service.findByAuthor("CERVANTES").size());
    }

    @Test
    public void fullNameInAnyCase_works() {
        Assert.assertEquals(2, service.findByAuthor("george orwell").size());
    }

    @Test
    public void unknownAuthor_stillReturnsEmptyList() {
        Assert.assertTrue(service.findByAuthor("nobody").isEmpty());
    }

    @Test
    public void partialName_isOutOfScope_stillReturnsEmptyList() {
        // Guards against doing more than the spec asked.
        Assert.assertTrue(service.findByAuthor("Cerv").isEmpty());
    }
}
