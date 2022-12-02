package bdm.test.shift.exception;

public class IllegalInputComputerParametersException extends RuntimeException {
    public IllegalInputComputerParametersException() {
        super("Computer must have one of those form-factor: 'desktop', 'nettop', 'monoblock'. Check parameters you tried to put.");
    }
}
