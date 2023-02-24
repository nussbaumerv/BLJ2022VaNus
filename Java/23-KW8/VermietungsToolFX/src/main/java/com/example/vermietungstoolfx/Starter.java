
package com.example.vermietungstoolfx;


import com.example.vermietungstoolfx.exceptions.MinorAgeException;
import com.example.vermietungstoolfx.vehicles.Car;
import com.example.vermietungstoolfx.vehicles.Rocket;

import java.time.LocalDate;

public class Starter {
    public static void main(String[] args) throws MinorAgeException {
        VehicleRentalManager manger = new VehicleRentalManager();
        int indexCar = manger.initializeCar(1, "Volvo", 22, "Black", "XC40", 18, "https://65e81151f52e248c552b-fe74cd567ea2f1228f846834bd67571e.ssl.cf1.rackcdn.com/ldm-images/2021-Volvo-XC40-Recharge-color-Onyx-Black-CA.jpg", false);
        Car car = manger.getCar(indexCar);

        int indexRock = manger.initializeRocket(1, "Volvo", 22, "Black", "XC40", 18, "https://65e81151f52e248c552b-fe74cd567ea2f1228f846834bd67571e.ssl.cf1.rackcdn.com/ldm-images/2021-Volvo-XC40-Recharge-color-Onyx-Black-CA.jpg", "Hydrogen");
        Rocket rocket = manger.getRocket(indexRock);

        int indexPerr = manger.addPerson("Valentin", "Nussbaumer", LocalDate.of(2000, 4, 8));
        Person person = manger.getPerson(indexPerr);


        manger.addPersonToDenyList(person);

        manger.createContract(car, person, LocalDate.of(2007, 4, 8), LocalDate.of(2008, 4, 8));
        manger.createContract(car, person, LocalDate.of(2007, 1, 8), LocalDate.of(2007, 3, 8));
    }
}
