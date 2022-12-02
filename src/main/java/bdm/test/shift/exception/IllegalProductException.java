package bdm.test.shift.exception;

public class IllegalProductException extends RuntimeException {
    public IllegalProductException() {
        super("Product with such NS already exists.");
    }
}
