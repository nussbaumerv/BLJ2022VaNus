package com.example.vermietungstoolfx;

import com.example.vermietungstoolfx.vehicles.Vehicle;

import java.time.LocalDate;

public class Contract {
    Vehicle vehicle;
    Person person;
    LocalDate startDate;
    LocalDate endDate;


    public Contract(Vehicle vehicle, Person person, LocalDate startDate, LocalDate endDate) {
        this.vehicle = vehicle;
        this.person = person;
        this.startDate = startDate;
        this.endDate = endDate;

            System.out.println("Creating contract");
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
