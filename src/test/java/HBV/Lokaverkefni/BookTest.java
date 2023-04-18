package HBV.Lokaverkefni;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTest {

    @Test
    public void testAddAuthor() {
        Author author1 = new Author("Agon");
        Author author2 = new Author("Helena Stef");
        List<Author> authors = new ArrayList<>();
        authors.add(author1);
        Book book = new Book("Book2", authors, 3);
        book.addAuthor(author2);
        List<Author> updatedAuthors = book.getAuthors();
        assertTrue(updatedAuthors.contains(author1));
        assertTrue(updatedAuthors.contains(author2));
    }

    @Test
    public void testSettersAndGetters() {
        Author author1 = new Author("J.K. Rowling");
        List<Author> authors = new ArrayList<>();
        authors.add(author1);
        Book book = new Book("Book2", authors, 3);
        book.setTitle("Book2");
        assertEquals("Book2", book.getTitle());
        book.setNumAvailableCopies(5);
        assertEquals(5, book.getNumAvailableCopies());
    }
}
