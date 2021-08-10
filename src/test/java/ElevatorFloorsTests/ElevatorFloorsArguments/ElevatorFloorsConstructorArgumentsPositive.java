package ElevatorFloorsTests.ElevatorFloorsArguments;

import elevator.models.ElevatorFloors;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ElevatorFloorsConstructorArgumentsPositive implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(new ElevatorFloors()),
                Arguments.of(new ElevatorFloors(-1, 10))
        );
    }
}
