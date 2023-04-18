package HBV.Lokaverkefni;

public class UserOrBookDoesNotExistException extends Exception {
    public UserOrBookDoesNotExistException(String message) {
        super("User or Book does not exist: " + message);
    }
}

