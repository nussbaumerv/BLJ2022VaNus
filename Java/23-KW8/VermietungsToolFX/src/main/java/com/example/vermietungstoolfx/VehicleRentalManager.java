package com.example.vermietungstoolfx;

import com.example.vermietungstoolfx.exceptions.DenylistedPersonException;
import com.example.vermietungstoolfx.exceptions.LeaseLengthCollisionException;
import com.example.vermietungstoolfx.exceptions.MinorAgeException;
import com.example.vermietungstoolfx.vehicles.Car;
import com.example.vermietungstoolfx.vehicles.Motorcycle;
import com.example.vermietungstoolfx.vehicles.Rocket;
import com.example.vermietungstoolfx.vehicles.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;

public class VehicleRentalManager {
    private ArrayList<Person> customerList = new ArrayList<Person>();
    private ArrayList<Person> denyList = new ArrayList<Person>();

    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    private ArrayList<Contract> contracts = new ArrayList<Contract>();

    public int initializeCar(int id, String producerName, int modelNumber, String color, String vehicleNumber, int minAge, String imgUrl, boolean automatic) {
        Car car = new Car(id, producerName, modelNumber, color, vehicleNumber, minAge, imgUrl, automatic);
        vehicles.add(car);
        int index = vehicles.indexOf(car);
        return index;
    }

    public int initializeRocket(int id, String producerName, int modelNumber, String color, String vehicleNumber, int minAge, String imgUrl, String engineType) {
        Rocket rocket = new Rocket(id, producerName, modelNumber, color, vehicleNumber, minAge, imgUrl, engineType);
        vehicles.add(rocket);
        int index = vehicles.indexOf(rocket);
        return index;
    }

    public int initializeMotorcycle(int id, String producerName, int modelNumber, String color, String vehicleNumber, int minAge, String imgUrl, boolean offRoad) {
        Motorcycle motorcycle = new Motorcycle(id, producerName, modelNumber, color, vehicleNumber, minAge, imgUrl, offRoad);
        vehicles.add(motorcycle);
        int index = vehicles.indexOf(motorcycle);
        return index;
    }

    public Car getCar(int index) {
        return (Car) vehicles.get(index);
    }

    public Vehicle getVehicle(int index) {
        return vehicles.get(index);
    }

    public Rocket getRocket(int index) {
        return (Rocket) vehicles.get(index);
    }

    public Person getPerson (int index) {
        return customerList.get(index);
    }

    public void checkIfBooked(LocalDate startDate, LocalDate endDate, Vehicle vehicle) throws LeaseLengthCollisionException {
        boolean free = true;
        for(int i = 0; i < contracts.size(); i++){
            if(contracts.get(i).getVehicle().equals(vehicle)){
                if(startDate.isBefore(contracts.get(i).getEndDate()) && endDate.isAfter(contracts.get(i).getStartDate())){
                    free = false;
                }

            }
        }

        if(!free){
            throw new LeaseLengthCollisionException();
        }

    }

    public void checkIfBlackListed(Person person) throws DenylistedPersonException {
        if (denyList.contains(person)) {
            throw new DenylistedPersonException();
        }

    }
    public void checkAge(Vehicle vehicle, Person person) throws MinorAgeException {
        if(person.getAge() < vehicle.getMinAge()){
            throw new MinorAgeException();
        }

    }

    public int createContract(Vehicle vehicle, Person person, LocalDate startDate, LocalDate endDate) throws MinorAgeException {
        int index = -1;
        try {
            checkIfBooked(startDate, endDate, vehicle);
            try {
                checkIfBlackListed(person);

                try {
                    checkAge(vehicle, person);

                    Contract contract = new Contract(vehicle, person, startDate, endDate);
                    contracts.add(contract);
                    index = contracts.indexOf(contract);

                }catch (MinorAgeException e){
                    System.out.println(e.getMessage());
                }
            } catch (DenylistedPersonException e) {
                System.out.println(e.getMessage());
            }
        } catch (LeaseLengthCollisionException e) {
            System.out.println(e.getMessage());
        }
        return index;
    }

    public int addPerson(String firstName, String lastName, LocalDate birthday) {
        Person person = new Person(firstName, lastName, birthday);
        customerList.add(person);
        int index = customerList.indexOf(person);
        System.out.println("Added Person: " + firstName + lastName + birthday.toString());
        return index;
    }

    public void addPersonToDenyList(Person person) {
        denyList.add(person);
    }

    public boolean checkIfOnDenyList(Person person) {
        boolean valid = denyList.contains(person);
        return valid;
    }

    public VehicleRentalManager() {

    }

    public ArrayList<Person> getCustomerList() {
        return customerList;
    }
}
