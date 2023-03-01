
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.spi.LocaleServiceProvider;

public class VehicleRentalManager {
    private ArrayList<Person> customerList = new ArrayList<Person>();
    private ArrayList<Person> denyList = new ArrayList<Person>();

    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    private ArrayList<Contract> contracts = new ArrayList<Contract>();

    public int initializeCar(int id, String producerName, int modelNumber, String color, String vehicleNumber, int minAge, boolean automatic) {
        Car car = new Car(id, producerName, modelNumber, color, vehicleNumber, minAge, automatic);
        vehicles.add(car);
        int index = vehicles.indexOf(car);
        return index;
    }

    public int initializeMotorcycle(int id, String producerName, int modelNumber, String color, String vehicleNumber, int minAge, boolean offRoad) {
        Motorcycle motorcycle = new Motorcycle(id, producerName, modelNumber, color, vehicleNumber, minAge, offRoad);
        vehicles.add(motorcycle);
        int index = vehicles.indexOf(motorcycle);
        return index;
    }

    public Car getCar(int index) {
        return (Car) vehicles.get(index);
    }

    public Person getPerson (int index) {
        return customerList.get(index);
    }

    public boolean checkIfBooked(LocalDate startDate, LocalDate endDate, Vehicle vehicle){
        boolean free = true;
        for(int i = 0; i < contracts.size(); i++){
            if(contracts.get(i).getVehicle().equals(vehicle)){
                if(startDate.isBefore(contracts.get(i).getEndDate()) && endDate.isAfter(contracts.get(i).getStartDate())){
                    free = false;
                }

            }
        }

        return free;
    }

    public int createContract(Vehicle vehicle, Person person, LocalDate startDate, LocalDate endDate) {
        int index = -1;
        if(checkIfBooked(startDate, endDate, vehicle)) {
            if (!denyList.contains(person)) {
                Contract contract = new Contract(vehicle, person, startDate, endDate);
                contracts.add(contract);
                index = contracts.indexOf(contract);
            } else {
                System.out.println("Blacklisted");
            }
        } else{
            System.out.println("Alredy booked");
        }
        return index;
    }

    public int addPerson(String firstName, String lastName, LocalDate birthday) {
        Person person = new Person(firstName, lastName, birthday);
        customerList.add(person);
        int index = customerList.indexOf(person);
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
}
