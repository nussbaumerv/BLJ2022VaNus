import java.time.LocalDate;

public class Starter {
    public static void main(String[] args) {
        VehicleRentalManager manger = new VehicleRentalManager();
        manger.initializeCar(1, "Volvo", 22, "Black", "XC40", 18, false);
        Car car = manger.getCar(0);
        System.out.println(car.isAutomatic());

        int indexPerr = manger.addPerson("Valentin", "Nussbaumer", LocalDate.of(2000, 4, 8));
        Person person = manger.getPerson(indexPerr);

        manger.createContract(car, person, LocalDate.of(2007, 4, 8), LocalDate.of(2008, 4, 8));
        manger.createContract(car, person, LocalDate.of(2007, 1, 8), LocalDate.of(2007, 2, 8));
    }
}