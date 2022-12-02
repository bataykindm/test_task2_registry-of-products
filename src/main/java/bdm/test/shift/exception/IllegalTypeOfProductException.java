package bdm.test.shift.exception;

public class IllegalTypeOfProductException extends RuntimeException {
    public IllegalTypeOfProductException() {
        super("It's attempt to work with unknown product.");
    }
}
