package ElevatorTests;

import ElevatorTests.ElevatorArguments.MoveElevatorToTheFloorArgumentsNegative;
import ElevatorTests.ElevatorArguments.MoveElevatorToTheFloorArgumentsPositive;
import elevator.Elevator;
import elevator.exceptions.DoorsAreOpenException;
import elevator.models.ElevatorFloors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestElevatorMoveElevatorToTheFloor {
    @ParameterizedTest
    @ArgumentsSource(MoveElevatorToTheFloorArgumentsPositive.class)
    void testMoveElevatorToTheFloor_PositiveCheckWithClosedDoors(Elevator elevator, int destinationFloor){
        elevator.moveElevatorToTheFloor(destinationFloor);
        Assertions.assertEquals(destinationFloor, elevator.getCurrentFloor());
    }

    @Test
    void testMoveElevatorToTheFloor_NegativeCheckOpenDoors(){
        Elevator elevator = new Elevator(1,new ElevatorFloors(1,10),true);
        assertThrows(DoorsAreOpenException.class,
                ()->elevator.moveElevatorToTheFloor(5));
    }
    @ParameterizedTest
    @ArgumentsSource(MoveElevatorToTheFloorArgumentsNegative.class)
    void testMoveElevatorToTheFloor_NegativeCheck(Elevator elevator, int destinationFloor, Class<Exception> expectedException){
        assertThrows(expectedException,
                ()->elevator.moveElevatorToTheFloor(destinationFloor));
    }
    @Test
    void testMoveElevatorToTheFloor_ZeroDestinationFloor(){
        Elevator elevator = new Elevator(1,new ElevatorFloors(-1,10),false);
        try {
            elevator.moveElevatorToTheFloor(0);
        } catch(DoorsAreOpenException e){
            try {
                Field field = Elevator.class.getDeclaredField("doorsOpen");
                field.setAccessible(true);
                field.set(elevator,true);
                elevator.moveElevatorToTheFloor(0);
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        }
        Assertions.assertEquals(1,elevator.getCurrentFloor());
    }
}
