package HBV.Lokaverkefni;

public class EmptyAuthorListException extends Exception {
    public EmptyAuthorListException(String message) {
        super("Author list is empty: " + message);
    }
}
