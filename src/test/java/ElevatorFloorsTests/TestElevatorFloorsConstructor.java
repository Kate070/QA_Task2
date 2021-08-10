package ElevatorFloorsTests;

import ElevatorFloorsTests.ElevatorFloorsArguments.ElevatorFloorsConstructorArgumentsNegative;
import ElevatorFloorsTests.ElevatorFloorsArguments.ElevatorFloorsConstructorArgumentsPositive;
import elevator.exceptions.IncorrectFloorException;
import elevator.models.ElevatorFloors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestElevatorFloorsConstructor {
    @ParameterizedTest
    @ArgumentsSource(ElevatorFloorsConstructorArgumentsPositive.class)
    void testElevatorConstructorPositive(ElevatorFloors elevatorFloors){
        Assertions.assertTrue(elevatorFloors.getMinFloor() != 0);
        Assertions.assertTrue(elevatorFloors.getMaxFloor() != 0);
        Assertions.assertTrue(elevatorFloors.getMaxFloor() > elevatorFloors.getMinFloor());
    }
    @ParameterizedTest
    @ArgumentsSource(ElevatorFloorsConstructorArgumentsNegative.class)
    void testElevatorConstructorNegative(int minFloor, int maxFloor){
        assertThrows(IncorrectFloorException.class,
                () -> new ElevatorFloors(minFloor,maxFloor));
    }
}
