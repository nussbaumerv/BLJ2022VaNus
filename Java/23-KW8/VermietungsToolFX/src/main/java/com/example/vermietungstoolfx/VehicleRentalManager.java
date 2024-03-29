package com.example.vermietungstoolfx;

import com.example.vermietungstoolfx.exceptions.DateOrderException;
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

    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Person> denyList = new ArrayList<Person>();

    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    private ArrayList<Contract> contracts = new ArrayList<Contract>();

    public int initializeVehicle(int id, String producerName, int modelNumber, String color, String vehicleNumber, int minAge, String imgUrl) {
        Vehicle vehicle = new Vehicle(id, producerName, modelNumber, color, vehicleNumber, minAge, imgUrl);
        vehicles.add(vehicle);
        int index = vehicles.indexOf(vehicle);
        return index;
    }

    public void updateVehicle(int index, String producerName, int modelNumber, String color, String vehicleNumber, int minAge, String imgUrl) {
        Vehicle vehicle = getVehicle(index);
        vehicle.setProducerName(producerName);
        vehicle.setModelNumber(modelNumber);
        vehicle.setColor(color);
        vehicle.setVehicleNumber(vehicleNumber);
        vehicle.setMinAge(minAge);
        vehicle.setImgUrl(imgUrl);
    }

    public void updatePerson(int index, String firstName, String lastName, LocalDate birthday){
        Person person = getPerson(index);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setBirthday(birthday);
    }

    public void deleteVehicle(int index){
        vehicles.remove(index);
    }

    public void deletePerson(int index){
        customerList.remove(index);
    }

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

    public int getVehicleByIndex(Vehicle vehicle) {
        return vehicles.indexOf(vehicle);
    }

    public Rocket getRocket(int index) {
        return (Rocket) vehicles.get(index);
    }

    public Person getPerson(int index) {
        return customerList.get(index);
    }

    public void checkIfBooked(LocalDate startDate, LocalDate endDate, Vehicle vehicle) throws LeaseLengthCollisionException {
        boolean free = true;
        for (int i = 0; i < contracts.size(); i++) {
            if (contracts.get(i).getVehicle().equals(vehicle)) {
                if (startDate.isBefore(contracts.get(i).getEndDate()) && endDate.isAfter(contracts.get(i).getStartDate())) {
                    free = false;
                }

            }
        }

        if (!free) {
            throw new LeaseLengthCollisionException();
        }

    }

    public void checkIfBlackListed(Person person) throws DenylistedPersonException {
        if (denyList.contains(person)) {
            throw new DenylistedPersonException();
        }

    }

    public boolean checkIfContracts(Person person){
        boolean contains = false;
        for(int i = 0; i < contracts.size(); i++){
            if(contracts.get(i).getPerson().equals(person)){
                contains = true;
            }
        }

        return contains;
    }

    public void checkAge(Vehicle vehicle, Person person) throws MinorAgeException {
        if (person.getAge() < vehicle.getMinAge()) {
            throw new MinorAgeException();
        }

    }

    public void checkDateOrder(LocalDate startDate, LocalDate endDate) throws DateOrderException {
        if (endDate.isBefore(startDate)) {
            throw new DateOrderException();
        }

    }


    public String createContract(Vehicle vehicle, Person person, LocalDate startDate, LocalDate endDate) throws MinorAgeException {
        String message = "ok";
        try {
            checkDateOrder(startDate, endDate);
            try {
                checkIfBooked(startDate, endDate, vehicle);
                try {
                    checkIfBlackListed(person);
                    try {
                        checkAge(vehicle, person);

                        Contract contract = new Contract(vehicle, person, startDate, endDate);
                        contracts.add(contract);

                    } catch (MinorAgeException e) {
                        message = e.getMessage();
                    }
                } catch (DenylistedPersonException e) {
                    message = e.getMessage();
                }
            } catch (LeaseLengthCollisionException e) {
                message = e.getMessage();
            }
        } catch (DateOrderException e) {
            message = e.getMessage();
        }
        return message;
    }

    public int addPerson(String firstName, String lastName, LocalDate birthday) {
        Person person = new Person(firstName, lastName, birthday);
        customerList.add(person);
        int index = customerList.indexOf(person);
        return index;
    }

    public void addEmployee(String firstName, String lastName, LocalDate birthday, String username, String password) {
        Employee employee = new Employee(firstName, lastName, birthday, username, password);
        employees.add(employee);
    }

    public boolean employeeLogin(String username, String password){
        boolean valid = false;
            for(int i = 0; i < employees.size(); i ++){
                if(employees.get(i).getUsername().equals(username) && employees.get(i).getPassword().equals(password)) {
                    valid = true;
                }

        }
        return valid;
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

    public int getVehicleListSize() {
        return vehicles.size();
    }
}
