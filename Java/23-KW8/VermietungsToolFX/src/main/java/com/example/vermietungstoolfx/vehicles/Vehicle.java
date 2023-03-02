package com.example.vermietungstoolfx.vehicles;

public class Vehicle{
    private int id;
    private String producerName;
    private int modelNumber;
    private String color;
    private String vehicleNumber;
    private int minAge;

    private String imgUrl;

    public Vehicle(int id, String producerName, int modelNumber, String color, String vehicleNumber, int minAge, String imgUrl){
        this.id = id;
        this.producerName = producerName;
        this.modelNumber = modelNumber;
        this.color = color;
        this.vehicleNumber = vehicleNumber;
        this.minAge = minAge;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public String getProducerName() {
        return producerName;
    }

    public int getModelNumber() {
        return modelNumber;
    }

    public String getColor() {
        return color;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public int getMinAge() {
        return minAge;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
    }

    public void setModelNumber(int modelNumber) {
        this.modelNumber = modelNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}