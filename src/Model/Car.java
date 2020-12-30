package Model;

public class Car extends Vehicle {

    public Car(String id, Road currentRoad)
    {
        super(currentRoad);
        this.id = "car_" + id;
        setLength(super.getLength());
        breadth = length / 3;
        position = -length;
    }

}

