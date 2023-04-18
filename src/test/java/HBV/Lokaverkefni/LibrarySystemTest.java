package HBV.Lokaverkefni;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibrarySystemTest {
    LibrarySystem library = new LibrarySystem();

    List<Author> authors1 = new ArrayList<>();
    List<Author> authors2 = new ArrayList<>();
    Book book = new Book("Test Book", new ArrayList<>(), 3);
    Book book2 = new Book("Test Book 2", new ArrayList<>(), 2);
    User user = library.findUserByName("Helena");


    @Before
    public void setUp() {
        LibrarySystem library = new LibrarySystem();
        library.addBookWithTitleAndAuthorlist("Test Book 1", new ArrayList<>());
        library.addBookWithTitleAndAuthorlist("Test Book 2", new ArrayList<>());

        authors1.add(new Author("John Doe"));
        authors1.add(new Author("Jane Smith"));
        authors1.add(new Author("Bob Johnson"));
        library.addBookWithTitleAndAuthorlist("Test Book 3", authors1);

    }

    @Test
    public void testAddBookWithTitleAndAuthorlist() {

        Book book1 = library.findBookByTitle("Test Book 1");
        assertNotNull(book1);
        assertEquals("Test Book 1", book1.getTitle());
        assertEquals(authors1, book1.getAuthors());
        assertEquals(0, book1.getNumAvailableCopies());

        // adding a book with more than one author
        Book book2 = library.findBookByTitle("Test Book 2");
        assertNotNull(book2);
        assertEquals("Test Book 2", book2.getTitle());
        assertEquals(authors2, book2.getAuthors());
        assertEquals(0, book2.getNumAvailableCopies());
    }

    @Test
    public void testAddBook() {

        library.addBook(book);
        Book foundBook = library.findBookByTitle("Test Book");
        assertNotNull(foundBook);
        assertEquals(book, foundBook);
    }

    @Test
    public void testAddStudentUser() {

        library.addStudentUser("Alice", false);
        assertNotNull(user);
        assertTrue(user instanceof Student);
        assertEquals("Alice", user.getName());
        assertFalse(((Student) user).isFeePaid());
    }

    @Test
    public void testAddFacultyMemberUser() {

        library.addFacultyMemberUser("Bob", "Computer Science");
        assertNotNull(user);
        assertTrue(user instanceof FacultyMember);
        assertEquals("Bob", user.getName());
        assertEquals("Computer Science", ((FacultyMember) user).getDepartment());
    }

    @Test
    public void testBorrowBook() {

        library.addBook(book2);
        User user = new Student("Alice", true);
        library.addStudentUser(user.getName(), ((Student) user).isFeePaid());

        library.borrowBook(user, book);
        assertEquals(1, book.getNumAvailableCopies());

    }
}
