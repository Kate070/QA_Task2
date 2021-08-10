package ElevatorFloorsTests;

import ElevatorFloorsTests.ElevatorFloorsArguments.HashCodeArguments;
import elevator.models.ElevatorFloors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

public class TestElevatorFloorsHashCode {
    @ParameterizedTest
    @ArgumentsSource(HashCodeArguments.class)
    void testHashCodePositive(ElevatorFloors elevatorFloors1, ElevatorFloors elevatorFloors2, boolean expectedResult){
        Assertions.assertEquals(elevatorFloors1.hashCode() == elevatorFloors2.hashCode(), expectedResult);
    }
}
