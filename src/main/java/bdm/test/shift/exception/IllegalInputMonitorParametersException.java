package bdm.test.shift.exception;

public class IllegalInputMonitorParametersException extends RuntimeException {
    public IllegalInputMonitorParametersException() {
        super("Monitor must have diagonal from 10.1 to 49. Check parameters you tried to put.");
    }
}
