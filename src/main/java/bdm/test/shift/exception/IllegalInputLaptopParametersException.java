package bdm.test.shift.exception;

public class IllegalInputLaptopParametersException extends RuntimeException {
    public IllegalInputLaptopParametersException() {
        super("Laptop must have one of those size: 13, 14, 15, 17. Check parameters you tried to put.");
    }
}
