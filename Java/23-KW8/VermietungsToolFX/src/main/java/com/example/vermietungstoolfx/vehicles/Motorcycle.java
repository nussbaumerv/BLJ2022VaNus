package com.example.vermietungstoolfx.vehicles;

public class Motorcycle extends Vehicle implements GroundVehicle {
    private boolean offRoad;
    public Motorcycle(int id, String producerName, int modelNumber, String color, String vehicleNumber, int minAge, String imgUrl, boolean offRoad) {
        super(id, producerName, modelNumber, color, vehicleNumber, minAge, imgUrl);
        this.offRoad = offRoad;
    }
}
