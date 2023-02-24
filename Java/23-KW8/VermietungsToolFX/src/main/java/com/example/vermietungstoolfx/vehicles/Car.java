package com.example.vermietungstoolfx.vehicles;

public class Car extends Vehicle implements GroundVehicle {
    private boolean automatic;
    public Car(int id, String producerName, int modelNumber, String color, String vehicleNumber, int minAge, String imgUrl, boolean automatic) {
        super(id, producerName, modelNumber, color, vehicleNumber, minAge, imgUrl);
        this.automatic = automatic;

    }

    public boolean isAutomatic() {
        return automatic;
    }
}
