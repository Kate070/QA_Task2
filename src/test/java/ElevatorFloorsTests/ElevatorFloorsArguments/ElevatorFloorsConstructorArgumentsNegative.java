package ElevatorFloorsTests.ElevatorFloorsArguments;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class ElevatorFloorsConstructorArgumentsNegative implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(10, -1),
                Arguments.of(0, 0),
                Arguments.of(0, 10),
                Arguments.of(-1, 0)
        );
    }
}
