package elevator.exceptions;

public class DoorsAreOpenException extends RuntimeException {

    public DoorsAreOpenException() {
        super("Impossible to go to the destination with open doors");
    }
}
