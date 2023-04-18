package HBV.Lokaverkefni;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    private Student student;

    @Before
    public void setUp() {
        student = new Student("Helena", false);
    }

    @Test
    public void testGetName() {
        assertEquals("Helena", student.getName());
    }

    @Test
    public void testSetName() {
        student.setName("Helena");
        assertEquals("Helena", student.getName());
    }

    @Test
    public void testfeepaid() {
        assertEquals(false, student.isFeePaid());
        student.setFeePaid(true);
    }

}

