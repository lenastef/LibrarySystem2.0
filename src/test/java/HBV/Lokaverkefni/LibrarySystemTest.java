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


    @Before
    public void setUp() {
        LibrarySystem library = new LibrarySystem();
        library.addBookWithTitleAndAuthorlist("Test Book 1", new ArrayList<>());
        library.addBookWithTitleAndAuthorlist("Test Book 2", new ArrayList<>());
        library.addBookWithTitleAndAuthorlist("Test Book 3", new ArrayList<>());

        authors1.add(new Author("lena"));
        authors1.add(new Author("lella"));
        authors1.add(new Author("helena"));
        library.addBookWithTitleAndAuthorlist("Test Book 3", authors1);

    }

    @Test
    public void testAddBookWithTitleAndAuthorlist() {

        Book book1 = library.findBookByTitle("Test Book 1");
        assertNotNull(book1);

        assertEquals("Test Book 1", book1.getTitle());
        assertEquals(authors1, book1.getAuthors());
        assertEquals(0, book1.getNumAvailableCopies());

        authors2.add(new Author("Jane Smith"));
        authors2.add(new Author("Bob Johnson"));
        library.addBookWithTitleAndAuthorlist("Test Book 2", authors2);
        Book book2 = library.findBookByTitle("Test Book 2");

        assertNotNull(book2);
        
        assertEquals("Test Book 2", book2.getTitle());
        assertEquals(authors2, book2.getAuthors());
        assertEquals(0, book2.getNumAvailableCopies());
    }


    @Test
    public void testAddBook() {

        Book book = new Book("Test Book", new ArrayList<>(), 3);
        library.addBook(book);
        Book foundBook = library.findBookByTitle("Test Book");
        assertNotNull(foundBook);
        assertEquals(book, foundBook);
    }

    @Test
    public void testAddStudentUser() {

        library.addStudentUser("Agon", false);
        User user = library.findUserByName("Agon");
        assertNotNull(user);
        assertTrue(user instanceof Student);
        assertEquals("Agon", user.getName());
        assertFalse(((Student) user).isFeePaid());
    }

    @Test
    public void testAddFacultyMemberUser() {

        library.addFacultyMemberUser("Helena", "Computer Science");
        User user = library.findUserByName("Helena");
        assertNotNull(user);
        assertTrue(user instanceof FacultyMember);
        assertEquals("Helena", user.getName());
        assertEquals("Computer Science", ((FacultyMember) user).getDepartment());
    }

    @Test
    public void testBorrowBook() {

        Book book = new Book("Test Book", new ArrayList<>(), 2);
        library.addBook(book);
        User user = new Student("Helena", true);
        library.addStudentUser(user.getName(), ((Student) user).isFeePaid());

        library.borrowBook(user, book);
        assertEquals(1, book.getNumAvailableCopies());

    }
}
