package elevator.exceptions;

public class IncorrectFloorException extends RuntimeException {

    public IncorrectFloorException(int minFloor, int maxFloor) {
        super(String.format("Incorrect floor was provided. Check that min floor %d is less than max floor %d. " +
                "Also floors cannot be equal to zero", minFloor, maxFloor));
    }

}
