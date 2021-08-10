package ElevatorFloorsTests.ElevatorFloorsArguments;

import elevator.models.ElevatorFloors;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class HashCodeArguments implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        ElevatorFloors elevatorFloors = new ElevatorFloors();
        ElevatorFloors elevatorFloors2 = new ElevatorFloors(1,10);
        return Stream.of(
                Arguments.of(elevatorFloors,elevatorFloors,true),
                Arguments.of(elevatorFloors,elevatorFloors2,false)
        );
    }
}
