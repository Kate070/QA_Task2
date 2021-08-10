package ElevatorFloorsTests.ElevatorFloorsArguments;

import elevator.models.ElevatorFloors;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class EqualsArguments implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        ElevatorFloors elevatorFloors = new ElevatorFloors();
        ElevatorFloors elevatorFloorsWithParams = new ElevatorFloors(1,10);
        ElevatorFloors elevatorFloorsWithParams2 = new ElevatorFloors(1,10);

        return Stream.of(
                Arguments.of(elevatorFloors, elevatorFloors, true),
                Arguments.of(elevatorFloorsWithParams, elevatorFloorsWithParams2, true),
                Arguments.of(elevatorFloors, new ElevatorFloors(1, 10), false),
                Arguments.of(elevatorFloors, null, false),
                Arguments.of(elevatorFloors, "", false)
        );
    }
}
