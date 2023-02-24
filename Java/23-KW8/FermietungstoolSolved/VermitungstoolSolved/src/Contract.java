import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Contract {
    Vehicle vehicle;
    Person person;
    LocalDate startDate;
    LocalDate endDate;

    public boolean checkValid() {
        boolean valid = false;

        if (person.getAge() >= vehicle.getMinAge()) {
            valid = true;

        }

        return valid;
    }

    public Contract(Vehicle vehicle, Person person, LocalDate startDate, LocalDate endDate) {
        this.vehicle = vehicle;
        this.person = person;
        this.startDate = startDate;
        this.endDate = endDate;

        if(checkValid()){
            System.out.println("Creating contract");
        } else{
            System.out.println("Invalid");
        }
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
