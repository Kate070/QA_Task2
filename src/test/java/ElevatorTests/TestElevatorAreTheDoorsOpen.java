package ElevatorTests;

import elevator.Elevator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

public class TestElevatorAreTheDoorsOpen {
    @Test
    void testElevatorAreDoorsOpen(){
        Elevator elevator = new Elevator();
        Field areDoorsOpenInitial;
        try {
            areDoorsOpenInitial = Elevator.class.getDeclaredField("doorsOpen");
            areDoorsOpenInitial.setAccessible(true);
            boolean beforeValue = (boolean)areDoorsOpenInitial.get(elevator);
            elevator.switchTheDoorsStatus();
            boolean afterValue = (boolean) areDoorsOpenInitial.get(elevator);
            Assertions.assertNotEquals(afterValue,beforeValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
