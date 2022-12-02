package bdm.test.shift.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("Product with such NS doesn't exist yet.");
    }
}
