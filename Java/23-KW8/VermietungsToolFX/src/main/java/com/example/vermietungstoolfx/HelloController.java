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
    public void initialize() {
        manager.initializeCar(1, "Volvo", 22, "Black", "XC40", 18, "https://65e81151f52e248c552b-fe74cd567ea2f1228f846834bd67571e.ssl.cf1.rackcdn.com/ldm-images/2021-Volvo-XC40-Recharge-color-Onyx-Black-CA.jpg", false);
        manager.initializeRocket(2, "Nasa", 1, "White", "Apollo 11", 18, "https://www.br.de/kinder/apollo-11-kapsel-saturn-mondrakete-mondlandung-100~_v-img__3__4__xl_-f4c197f4ebda83c772171de6efadd3b29843089f.jpg?version=aae68", "Space IDK");
        manager.initializeMotorcycle(3, "Aprilia", 1, "Red", "SX 125", 16, "https://images.piaggio.com/aprilia/vehicles/ap6161s00ecn00/ap6161s00ecnb6/ap6161s00ecnb6-01-s.png", true);


        onLoadVehicle(1);

    }

    private int indexVehicle;

    private String password = "1234";

    private int idCounter = 3;

    private int currentTab;
    private int selectedPerson = -1;
    private int selectedPersonDeny = -1;

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
    private Label alertMessage;

    @FXML
    private Label contractDate;

    @FXML
    private MenuButton PersonToDeny;

    @FXML
    private Label denyPersonSelected;

    @FXML
    private TextField producerNameNew;

    @FXML
    private TextField modelNumberNew;

    @FXML
    private TextField colorNew;

    @FXML
    private TextField nameOfVehicleNew;

    @FXML
    private TextField minAgeNew;

    @FXML
    private TextField imgUrlNew;

    @FXML
    private PasswordField passwordField;
    @FXML
    protected void onSavePerson() {
        if(firstName.getText().isEmpty() || lastName.getText().isEmpty() || birthDay.getValue() == null){
            currentTab = 0;
            showAlert("Not all fields a filled up");
        } else {
            manager.addPerson(firstName.getText(), lastName.getText(), birthDay.getValue());
            firstName.clear();
            lastName.clear();
            birthDay.getEditor().clear();
            tabPane.getSelectionModel().select(1);
            currentTab = 1;
            onLoadVehicle(indexVehicle);
        }
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
        if(startDate.getValue() == null || endDate.getValue() == null || selectedPerson == -1){
            showAlert("Not all fields a filled up");
        } else {
            Vehicle vehicle = currentVehicle;

            Person person = manager.getPerson(selectedPerson);

            String msg = manager.createContract(vehicle, person, startDate.getValue(), endDate.getValue());

            if (msg.equals("ok")) {
                startDate.getEditor().clear();
                endDate.getEditor().clear();
                personSelected.setText("None Person selected");
                selectedPerson = -1;

                tabPane.getSelectionModel().select(2);
                currentTab = 2;
                contractVehicleBrand.setText("Model: " + vehicle.getVehicleNumber());
                contractVehicleName.setText("Producer: " + vehicle.getProducerName());
                contractRenterName.setText(person.getFirstName() + " " + person.getLastName());
                contractDate.setText("From " + startDate.getValue().toString() + " to " + endDate.getValue().toString());
            } else {
                showAlert(msg);
            }
        }
    }

    @FXML
    protected void onLoadDeny() {
        System.out.println("it's a start");

        PersonToDeny.getItems().clear();

        ArrayList<Person> persons = manager.getCustomerList();
        for(int i = 0; i < persons.size(); i++){
            EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e)
                {
                    denyPersonSelected.setText(((MenuItem)e.getSource()).getText() + " selected");
                    selectedPersonDeny = Integer.parseInt(((MenuItem)e.getSource()).getId());
                }
            };
            System.out.println("go");

            MenuItem menuItem = new MenuItem(persons.get(i).getFirstName() + " " + persons.get(i).getLastName());
            menuItem.setOnAction(event2);
            menuItem.setId("" + i);

            PersonToDeny.getItems().add(menuItem);
        }
        tabPane.getSelectionModel().select(6);
    }


    @FXML
    protected void addToDenyList() {
            if(selectedPersonDeny == -1){
            showAlert("Not all fields a filled up");
        } else {
            Person person = manager.getPerson(selectedPersonDeny);
            manager.addPersonToDenyList(person);
            tabPane.getSelectionModel().select(5);
        }
    }

    @FXML
    protected void addVehicle() {
        if(producerNameNew.getText().isEmpty() || modelNumberNew.getText().isEmpty() || colorNew.getText().isEmpty() || nameOfVehicleNew.getText().isEmpty() || minAgeNew.getText().isEmpty() || imgUrlNew.getText().isEmpty()){
            showAlert("Not all fields a filled up");
        } else {
            idCounter++;

            int modelNumberInt = Integer.parseInt(modelNumberNew.getText());
            int minAgeInt = Integer.parseInt(minAgeNew.getText());

            manager.initializeVehicle(idCounter, producerNameNew.getText(), modelNumberInt, colorNew.getText(), nameOfVehicleNew.getText(), minAgeInt, imgUrlNew.getText());
            tabPane.getSelectionModel().select(1);
        }
    }

    @FXML
    protected void nextVehicle() {
        if(indexVehicle < manager.getVehicleListSize() - 1){
            onLoadVehicle(indexVehicle + 1);
        } else{
            showAlert("Can't go further");
        }
    }

    @FXML
    protected void lastVehicle() {
        if(indexVehicle > 0){
            onLoadVehicle(indexVehicle - 1);
        } else{
            showAlert("Can't go back");
        }
    }

    @FXML
    protected void rentMore(){
        tabPane.getSelectionModel().select(1);
        currentTab = 1;
        onLoadVehicle(0);
    }

    @FXML
    protected void showAlert(String message){
        alertMessage.setText(message);
        tabPane.getSelectionModel().select(3);
    }

    @FXML
    protected void goBackToTab(){
        tabPane.getSelectionModel().select(currentTab);
    }

    @FXML
    protected void goToLogin(){
        tabPane.getSelectionModel().select(4);
    }

    @FXML
    protected void login(){
        if(password.equals(passwordField.getText())){
            tabPane.getSelectionModel().select(5);
        } else{
            currentTab = 5;
            showAlert("Wrong Password");
        }
    }

    @FXML
    protected void goToAddVehicle(){
        tabPane.getSelectionModel().select(7);
    }

    @FXML
    protected void exitAdmin(){
        tabPane.getSelectionModel().select(1);
    }


}