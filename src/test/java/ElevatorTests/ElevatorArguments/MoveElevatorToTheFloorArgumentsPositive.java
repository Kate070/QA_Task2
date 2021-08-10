package ElevatorTests.ElevatorArguments;

import elevator.Elevator;
import elevator.models.ElevatorFloors;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class MoveElevatorToTheFloorArgumentsPositive implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(new Elevator(1,new ElevatorFloors(-1,10),false),1),
                Arguments.of(new Elevator(1,new ElevatorFloors(-1,10),false),-1),
                Arguments.of(new Elevator(10,new ElevatorFloors(-1,10),false),-1),
                Arguments.of(new Elevator(-1,new ElevatorFloors(-1,10),false),10)
        );
    }
}
