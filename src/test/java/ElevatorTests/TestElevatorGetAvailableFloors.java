package ElevatorTests;

import elevator.Elevator;
import elevator.models.ElevatorFloors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestElevatorGetAvailableFloors {
    Elevator elevator;
    @BeforeEach
    void setupElevator(){
        elevator = new Elevator(1,new ElevatorFloors(-2,10),false);
    }
    @Test
    void testGetAvailableFloorsSize(){
        Assertions.assertEquals(12,elevator.getAvailableFloors().size());
    }
    @Test
    void testGetAvailableFloorsNotContainsZeroFloor(){
        Assertions.assertFalse(elevator.getAvailableFloors().contains(0));
    }
}
