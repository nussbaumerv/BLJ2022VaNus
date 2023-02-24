package com.example.vermietungstoolfx.vehicles;

public class Rocket extends Vehicle implements SkyVehicle {
    private String engineType;
    public Rocket(int id, String producerName, int modelNumber, String color, String vehicleNumber, int minAge, String imgUrl, String engineType) {
        super(id, producerName, modelNumber, color, vehicleNumber, minAge, imgUrl);
        this.engineType = engineType;
    }
}
