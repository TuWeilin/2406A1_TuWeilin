package Model;

public class Motorbike extends Vehicle {

    public Motorbike(String id, Road currentRoad) {
        super(currentRoad);
        this.id = ("bike_" + id);
        setLength(super.getLength() / 3);
        breadth = super.getBreadth() / 3;
        position = -length;
    }

}
