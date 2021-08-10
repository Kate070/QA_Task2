package elevator.exceptions;

public class FloorOutOfBoundException extends RuntimeException {

    public FloorOutOfBoundException(int destinationFloor) {
        super(String.format("Destination floor %d is out of bound of preset min and max floors", destinationFloor));
    }
}
