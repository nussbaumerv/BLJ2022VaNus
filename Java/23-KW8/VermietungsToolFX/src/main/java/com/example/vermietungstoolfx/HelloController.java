package com.example.vermietungstoolfx;

import com.example.vermietungstoolfx.exceptions.MinorAgeException;
import com.example.vermietungstoolfx.vehicles.Car;
import com.example.vermietungstoolfx.vehicles.Vehicle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.util.ArrayList;

public class HelloController {

    VehicleRentalManager manager = new VehicleRentalManager();

    int indexCar = manager.initializeCar(1, "Volvo", 22, "Black", "XC40", 18, "https://65e81151f52e248c552b-fe74cd567ea2f1228f846834bd67571e.ssl.cf1.rackcdn.com/ldm-images/2021-Volvo-XC40-Recharge-color-Onyx-Black-CA.jpg", false);
    Car car = manager.getCar(indexCar);


    private int selectedPerson;

    private Vehicle currentVehicle;


    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private DatePicker birthDay;

    @FXML
    private DatePicker startDate;

    @FXML
    private DatePicker endDate;

    @FXML
    private MenuButton PersonSelection;

    @FXML
    private Label vehicleName;

    @FXML
    private Label vehicleID;

    @FXML
    private Label personSelected;

    @FXML
    private ImageView imageView;
    @FXML
    protected void onSavePerson() {
        manager.addPerson(firstName.getText(), lastName.getText(), birthDay.getValue());
        firstName.clear();
        lastName.clear();
        //birthDay.disarm();
        onLoadVehicle(0);
    }

    @FXML
    protected void onLoadVehicle(int index) {
        Vehicle vehicle = manager.getVehicle(index);
        vehicleName.setText(vehicle.getVehicleNumber());
        currentVehicle = vehicle;

        Image image = new Image(vehicle.getImgUrl());
        imageView.setImage(image);




        ArrayList<Person> persons = manager.getCustomerList();
        for(int i = 0; i < persons.size(); i++){
            EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e)
                {
                    personSelected.setText(((MenuItem)e.getSource()).getText() + " selected");
                    selectedPerson = Integer.parseInt(((MenuItem)e.getSource()).getId());
                }
            };

            MenuItem menuItem = new MenuItem(persons.get(i).getFirstName() + " " + persons.get(i).getLastName());
            menuItem.setOnAction(event1);
            menuItem.setId("" + i);

            PersonSelection.getItems().add(menuItem);
        }
    }

    @FXML
    protected void onRent() throws MinorAgeException {;
        Vehicle vehicle = currentVehicle;

        Person person = manager.getPerson(selectedPerson);

        manager.createContract(vehicle, person, startDate.getValue(), endDate.getValue());
    }
}