package HBV.Lokaverkefni;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User {
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean canBorrow() {
        return true;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    public Collection<Object> getBorrowedBooks() {
        return null;

    }
}
