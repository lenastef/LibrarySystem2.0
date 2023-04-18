package HBV.Lokaverkefni;

import java.util.List;

public class Book {
    private String title;
    private List<Author> authors;
    private int numAvailableCopies;
    Book newBook = new Book(title, authors, numAvailableCopies);


    public Book(String title, List<Author> authors, int numAvailableCopies) {
        this.title = title;
        this.authors = authors;
        this.numAvailableCopies = numAvailableCopies;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumAvailableCopies() {
        return numAvailableCopies;
    }

    public void setNumAvailableCopies(int numAvailableCopies) {
        this.numAvailableCopies = numAvailableCopies;
    }
}
