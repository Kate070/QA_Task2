package ElevatorFloorsTests;

import ElevatorFloorsTests.ElevatorFloorsArguments.EqualsArguments;
import elevator.models.ElevatorFloors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class TestElevatorFloorsEquals {
    @ParameterizedTest
    @ArgumentsSource(EqualsArguments.class)
    void testEquals(ElevatorFloors o1, Object o2, boolean expectedResult) {
        Assertions.assertEquals(o1.equals(o2),expectedResult);
    }
}
