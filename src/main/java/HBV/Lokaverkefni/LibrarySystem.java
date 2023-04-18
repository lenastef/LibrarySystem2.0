package HBV.Lokaverkefni;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

    private final List<Book> books;
    private final List<User> users;
    private final List<Lending> lendings;

    public LibrarySystem() {
        books = new ArrayList<>();
        users = new ArrayList<>();
        lendings = new ArrayList<>();
    }

    public void addBookWithTitleAndAuthorlist(String title, List<Author> authors) {
        Book newBook = new Book(title, authors, 0);
        books.add(newBook);

    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addStudentUser(String name, boolean feePaid) {
        Student newStudent = new Student(name, false);
        users.add(newStudent);
    }

    public void addFacultyMemberUser(String name, String department) {
        FacultyMember newFacultyMember = new FacultyMember(name, department);
        users.add(newFacultyMember);
    }

    public Book findBookByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().equals(title)).findFirst().orElse(null);
    }

    public User findUserByName(String name) {
        return users.stream().filter(user -> user.getName().equals(name)).findFirst().orElse(null);
    }

    public void borrowBook(User user, Book book) {
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (!user.canBorrow()) {
            System.out.println(user.getName() + " cannot borrow more books at this time.");
            return;
        }
        if (user instanceof Student && !((Student) user).isFeePaid()) {
            System.out.println(user.getName() + " has not paid the library fee.");
            return;
        }
        if (book.getNumAvailableCopies() == 0) {
            System.out.println("No available copies of " + book.getTitle() + " to borrow.");
            return;
        }
        Lending newLending = new Lending(user, book);
        lendings.add(newLending);
        book.setNumAvailableCopies(book.getNumAvailableCopies() - 1);
        user.addBorrowedBook(book);
    }

    public void extendLending(Student student, Book book, LocalDate newDueDate) {
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        for (Lending lending : lendings) {
            if (lending.getBorrower() == student && lending.getBook() == book) {
                lending.setDueDate(newDueDate);
                return;
            }
        }
        System.out.println("Lending not found.");
    }

    public void returnBook(User user, Book book) {
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        for (Lending lending : lendings) {
            if (lending.getBorrower() == user && lending.getBook() == book) {
                lendings.remove(lending);
                book.setNumAvailableCopies(book.getNumAvailableCopies() + 1);
                user.removeBorrowedBook(book);
                return;
            }
        }
        System.out.println("Lending not found.");
    }


}
