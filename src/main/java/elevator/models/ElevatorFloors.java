package elevator.models;

import elevator.exceptions.IncorrectFloorException;

import java.util.Objects;


/**
 * Класс-модель, хранящий в себе минимальный и максимальный этаж, на который может подниматься и опускаться лифт.
 * Минимальный этаж должен быть обязательно меньше, чем максимальный этаж, а также этаж не может быть нулевым.
 * Отрицательные этажи считаются подземными. Например, если это торговый центр, то подземная парковка это -1 этаж.
 * В четырехэтажном торговом центре с подземной парковкой у лифта будут возможны этажи -1, 1, 2, 3, 4.
 */
public class ElevatorFloors {
    private int minFloor = 0;
    private int maxFloor = 0;

    public ElevatorFloors() {}

    /**
     *
     * @throws IncorrectFloorException когда минимальный этаж больше или равен максимальному или
     * одно из ограничений равно нулю
     * @param minFloor минимально возможный этаж
     * @param maxFloor максимально возможный этаж
     */
    public ElevatorFloors(int minFloor, int maxFloor) {
        if (minFloor >= maxFloor) {
            throw new IncorrectFloorException(minFloor, maxFloor);
        }

        if (maxFloor == 0 || minFloor == 0) {
            throw new IncorrectFloorException(minFloor, maxFloor);
        }

        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElevatorFloors that = (ElevatorFloors) o;
        return minFloor == that.minFloor && maxFloor == that.maxFloor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minFloor, maxFloor);
    }
}
