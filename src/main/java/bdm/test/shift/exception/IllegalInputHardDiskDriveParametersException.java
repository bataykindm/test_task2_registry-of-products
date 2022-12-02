package bdm.test.shift.exception;

public class IllegalInputHardDiskDriveParametersException extends RuntimeException {
    public IllegalInputHardDiskDriveParametersException() {
        super("HDD must have capacity more than 64 Gb and be %64.");
    }
}
