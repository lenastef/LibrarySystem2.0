package HBV.Lokaverkefni;

public class FacultyMember extends User {
    public String name;
    public String department;

    public FacultyMember(String name, String department) {
        super(name);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
