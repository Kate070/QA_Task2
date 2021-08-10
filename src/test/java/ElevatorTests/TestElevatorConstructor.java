package ElevatorTests;

import elevator.Elevator;
import elevator.models.ElevatorFloors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Map;

public class TestElevatorConstructor {
    @Test
    void testElevatorConstructor(){
        Map<String,Object> values = Map.of("currentFloor",1,"elevatorFloors",new ElevatorFloors(-1,10),"doorsOpen",false);
        Elevator elevator = new Elevator(1,new ElevatorFloors(-1,10),false);
        Field[] fields = Elevator.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Assertions.assertEquals(field.get(elevator),values.get(field.getName()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }
}
