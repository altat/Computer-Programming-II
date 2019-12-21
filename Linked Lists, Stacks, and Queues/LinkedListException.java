/**
 * @author Tanvir Tatla
 *
 * This class inherits from Exception and is meant to be used to by the
 * List, Stack, and Queue classes to throw exceptions in unusual, corner cases.
 */
public class LinkedListException extends Exception{

    public LinkedListException(String message) {
        super(message);
    }

    public LinkedListException() {
        super();
    }
}
