package HBV.Lokaverkefni;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuthorTest {
    Author author = new Author("Agon");

    @Before
    public void setUp() {
        author.setName("Helena", "Agon");
    }

    @Test
    public void testGetName() {

        assertEquals("Agon", author.getName());
    }

    @Test
    public void testSetName() {
        assertEquals("Agon", author.getName());
    }
}
