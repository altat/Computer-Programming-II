/**
 * @author Tanvir Tatla
 *
 * This class inherits from Exception.
 */
public class ItemNotFoundException extends Exception {
    /**
     * Constructor with a pre-made message
     */
    public ItemNotFoundException() {
        super("Item is not found");
    }

    /**
     * Constructor that takes a message
     */
    public ItemNotFoundException(String message) {
        super(message);
    }
}