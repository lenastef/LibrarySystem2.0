package HBV.Lokaverkefni;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FacultyMemberTest {

    private FacultyMember facultyMember;

    @BeforeEach
    public void setUp() {
        facultyMember = new FacultyMember("John Doe", "Computer Science");
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", facultyMember.getName());
    }

    @Test
    public void testGetDepartment() {
        assertEquals("Computer Science", facultyMember.getDepartment());
    }

    @Test
    public void testCanBorrow() {
        assertTrue(facultyMember.canBorrow());
    }

}
