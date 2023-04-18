package HBV.Lokaverkefni;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LendingTest {

    private Book book;
    private User user;
    private LocalDate dueDate;
    private Lending lending;
    Book newBook = new Book("Bók", new ArrayList<>(), 281);

    @Before
    public void setUp() {
        user = new User("Agon");
        dueDate = LocalDate.now().plusDays(21);
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("Helena"));
        book = new Book("Book", authors, 281);
        lending = new Lending(book, user, dueDate);
    }

    @Test
    public void testGetDueDate() {
        assertEquals(dueDate, lending.getDueDate());
    }

    @Test
    public void testSetDueDate() {
        LocalDate newDueDate = LocalDate.now().plusDays(21);
        lending.setDueDate(newDueDate);
        assertEquals(newDueDate, lending.getDueDate());
    }

    @Test
    public void testGetBook() {
        assertEquals(book, lending.getBook());
    }

    @Test
    public void testSetBook() {
        lending.setBook(newBook);
        assertEquals(newBook, lending.getBook());
    }

    @Test
    public void testGetUser() {
        assertEquals(user, lending.getUser());
    }

    @Test
    public void testSetUser() {
        User newUser = new User("Helena");
        lending.setUser(newUser);
        assertEquals(newUser, lending.getUser());
    }

    @Test
    public void testGetBorrower() {
        assertEquals(user, lending.getBorrower());
    }
}
