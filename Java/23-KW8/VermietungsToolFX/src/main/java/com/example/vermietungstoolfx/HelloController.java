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
    public void initialize(){
        manager.initializeCar(1, "Volvo", 22, "Black", "XC40", 18, "https://65e81151f52e248c552b-fe74cd567ea2f1228f846834bd67571e.ssl.cf1.rackcdn.com/ldm-images/2021-Volvo-XC40-Recharge-color-Onyx-Black-CA.jpg", false);
        manager.initializeRocket(2, "Nasa", 1, "White", "Apollo 11", 18, "https://www.br.de/kinder/apollo-11-kapsel-saturn-mondrakete-mondlandung-100~_v-img__3__4__xl_-f4c197f4ebda83c772171de6efadd3b29843089f.jpg?version=aae68", "Space IDK");

        onLoadVehicle(1);

    }

    private int indexVehicle;


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
    private Label vehicleBrand;

    @FXML
    private Label personSelected;

    @FXML
    private ImageView imageView;

    @FXML
    private TabPane tabPane;

    @FXML
    private Label contractVehicleName;

    @FXML
    private Label contractVehicleBrand;

    @FXML
    private Label contractRenterName;

    @FXML
    private Label contractDate;
    @FXML
    protected void onSavePerson() {
        manager.addPerson(firstName.getText(), lastName.getText(), birthDay.getValue());
        firstName.clear();
        lastName.clear();
        birthDay.getEditor().clear();
        tabPane.getSelectionModel().select(1);
        onLoadVehicle(indexVehicle);
    }

    @FXML
    protected void onLoadVehicle(int index) {
        indexVehicle = index;
        Vehicle vehicle = manager.getVehicle(index);
        vehicleName.setText(vehicle.getVehicleNumber());
        vehicleBrand.setText(vehicle.getProducerName());
        currentVehicle = vehicle;

        Image image = new Image(vehicle.getImgUrl());
        imageView.setImage(image);

        PersonSelection.getItems().clear();

        EventHandler<ActionEvent> eventAdd = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                tabPane.getSelectionModel().select(0);

            }
        };
        MenuItem menuItem = new MenuItem("Add new Costumer");
        menuItem.setOnAction(eventAdd);
        PersonSelection.getItems().add(menuItem);


        ArrayList<Person> persons = manager.getCustomerList();
        for(int i = 0; i < persons.size(); i++){
            EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e)
                {
                    personSelected.setText(((MenuItem)e.getSource()).getText() + " selected");
                    selectedPerson = Integer.parseInt(((MenuItem)e.getSource()).getId());
                }
            };

            menuItem = new MenuItem(persons.get(i).getFirstName() + " " + persons.get(i).getLastName());
            menuItem.setOnAction(event1);
            menuItem.setId("" + i);

            PersonSelection.getItems().add(menuItem);
        }
    }

    @FXML
    protected void onRent() throws MinorAgeException {;
        Vehicle vehicle = currentVehicle;

        Person person = manager.getPerson(selectedPerson);

        int index = manager.createContract(vehicle, person, startDate.getValue(), endDate.getValue());

        if(index == -1){
            System.out.println("Invalid");
        } else {
            startDate.getEditor().clear();
            endDate.getEditor().clear();
            personSelected.setText("None Person selected");
            selectedPerson = -1;

            tabPane.getSelectionModel().select(2);
            contractVehicleBrand.setText("Model: "  + vehicle.getProducerName());
            contractVehicleName.setText("Producer: " + vehicle.getVehicleNumber());
            contractRenterName.setText(person.getFirstName() + " " + person.getLastName());
            contractDate.setText("From " + startDate.getValue().toString() + " to " + endDate.getValue().toString());
        }
    }

    @FXML
    protected void nextVehicle() {
        if(indexVehicle < manager.getVehicleListSize()){
            onLoadVehicle(indexVehicle + 1);
        }
    }

    @FXML
    protected void lastVehicle() {
        if(indexVehicle > 0){
            onLoadVehicle(indexVehicle - 1);
        }
    }

    @FXML
    protected void rentMore(){
        tabPane.getSelectionModel().select(1);
        onLoadVehicle(0);
    }
}