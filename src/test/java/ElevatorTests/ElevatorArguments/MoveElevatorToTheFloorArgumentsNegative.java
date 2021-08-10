package ElevatorTests.ElevatorArguments;

import elevator.Elevator;
import elevator.exceptions.DoorsAreOpenException;
import elevator.exceptions.FloorOutOfBoundException;
import elevator.models.ElevatorFloors;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class MoveElevatorToTheFloorArgumentsNegative implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(new Elevator(1,new ElevatorFloors(1,10),true), 2, DoorsAreOpenException.class),
                Arguments.of(new Elevator(1,new ElevatorFloors(-1,10),false),11, FloorOutOfBoundException.class),
                Arguments.of(new Elevator(1,new ElevatorFloors(-2,10),false),-3, FloorOutOfBoundException.class),
                Arguments.of(new Elevator(-5,new ElevatorFloors(-1,10),true),5, FloorOutOfBoundException.class)
        );
    }
}
