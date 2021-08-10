package elevator;

import elevator.exceptions.DoorsAreOpenException;
import elevator.exceptions.FloorOutOfBoundException;
import elevator.models.ElevatorFloors;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс лифта. Перед пользователем при входе в лифт высвечивается экран, как на смартфоне, с цифрами от 0 до 9.
 * Пользователь может ввести любой этаж и лифт должен понимать, может он туда отправиться или не может. Если лифт
 * не может переместиться на указанный пользователем этаж, то пользователю вернется ошибка с указанием причины,
 * почему на этаж переместиться нельзя.
 */
public class Elevator {
    private int currentFloor = 1;
    private ElevatorFloors elevatorFloors = new ElevatorFloors(); // 0 - 0
    private boolean doorsOpen = false;

    public Elevator() {}

    public Elevator(int currentFloor, ElevatorFloors elevatorFloors, boolean doorsOpen) {
        this.currentFloor = currentFloor;
        this.elevatorFloors = elevatorFloors;
        this.doorsOpen = doorsOpen;
    }

    /**
     * Метод перемещения лифта на указанный этаж. Метод учитывает, что если двери открыты, то движение не может быть
     * осуществлено, так как с открытыми дверьми двигаться не безопасно. Также если передан этаж не подходящий под
     * возможные этажи для перещения, то лифт не должен продолжить движение. Движение будет осуществлено, если этаж
     * назначения отличается от текущего.
     * @throws FloorOutOfBoundException когда этаж выходит за границы минимального и максимального или равен нулю.
     * @throws DoorsAreOpenException когда двери открыты при попытке начать движение.
     * @param destinationFloor этаж назначения.
     */
    public void moveElevatorToTheFloor(int destinationFloor) { // 2
        if (destinationFloor < elevatorFloors.getMinFloor() || destinationFloor > elevatorFloors.getMaxFloor()) {
            throw new FloorOutOfBoundException(destinationFloor);
        }

        if (!areTheDoorsOpen()) {
            throw new DoorsAreOpenException(); // 3
        }

        if (destinationFloor != currentFloor) {
            currentFloor = destinationFloor;
        }
    }

    /**
     * Метод, возвращающий список возможных для выбора этажей.
     * @return Список этажей от минимального до максимального включительно без нуля.
     */
    public List<Integer> getAvailableFloors() { //4
        List<Integer> listOfAvailableFloors = new ArrayList<>(
                elevatorFloors.getMaxFloor() - elevatorFloors.getMinFloor());

        for (int i = elevatorFloors.getMinFloor(); i < elevatorFloors.getMaxFloor(); i = i + 1 == 0 ? i + 2 : i + 1) {
            listOfAvailableFloors.add(i);
        }

        return listOfAvailableFloors;
    }

    /**
     * Получения состояния дверей.
     * @return true - двери открыты, false - двери закрыты.
     */
    public boolean areTheDoorsOpen() {
        return doorsOpen;
    }

    /**
     * Метод переключения состояния дверей с открытого на закрытое и с закрытого на открытое.
     */
    public void switchTheDoorsStatus() {
        doorsOpen = !doorsOpen;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

}
