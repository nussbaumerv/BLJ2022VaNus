package com.example.vermietungstoolfx;

import com.example.vermietungstoolfx.exceptions.MinorAgeException;
import com.example.vermietungstoolfx.vehicles.Vehicle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.awt.Desktop;

public class HelloController {

    VehicleRentalManager manager = new VehicleRentalManager();

    public void initialize() {
        manager.initializeCar(1, "BMW", 2022, "Black", "M4", 18, "https://www.bmw-m.com/content/dam/bmw/marketBMW_M/common/all-models/m-automobile/m4-x-kith/bmw-m4-x-kith-ms-02.jpg", false);
        manager.initializeRocket(2, "Nasa", 2000, "White", "Apollo 11", 18, "https://static.nationalgeographic.co.uk/files/styles/image_3200/public/apollo-anniversary-gettyimages-515392088.jpg?w=1600&h=900", "Space IDK");
        manager.initializeMotorcycle(3, "Aprilia", 2018, "Red", "SX 125", 16, "https://www.motorcyclespecs.co.za/Gallery%20B/aprilia-sx125-18-01.jpg", true);
        manager.initializeVehicle(4, "Specialized", 2018, "Black", "Stumpjumpe", 0, "https://u7q2x7c9.stackpathcdn.com/photos/24/25/364013_735_XL.jpg");

        manager.addEmployee("Valentin", "Nussbaumer", LocalDate.of(2007, 4, 8), "valentin", "1234");

        onLoadVehicle(0);
        tabPane.getSelectionModel().select(10);


    }

    private int indexVehicle;

    private int indexPerson = 0;

    private String adminPassword = "1234";

    private int idCounter = 4;

    private int currentTab;
    private int selectedPerson = -1;
    private int selectedPersonDeny = -1;

    private Vehicle currentVehicle;

    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;

    @FXML
    private Button logoutButton;
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
    private Hyperlink linkToPDF;

    @FXML
    private PasswordField adminPasswordField;

    @FXML
    private TextField producerNameEdit;

    @FXML
    private TextField modelNumberEdit;

    @FXML
    private TextField colorEdit;

    @FXML
    private TextField nameOfVehicleEdit;

    @FXML
    private TextField minAgeEdit;

    @FXML
    private TextField imgUrlEdit;

    @FXML
    private TextField firstNameEdit;

    @FXML
    private TextField lastNameEdit;

    @FXML
    private DatePicker birthDayEdit;

    @FXML
    protected void goToUserLogin() {
        tabPane.getSelectionModel().select(11);
    }

    @FXML
    protected void employeeLogin() {
        if (manager.employeeLogin(usernameField.getText(), passwordField.getText())) {
            tabPane.getSelectionModel().select(0);
            logoutButton.setVisible(true);
        } else {
            currentTab = 11;
            showAlert("Wrong Password");
        }
    }
    @FXML
    protected void extUserLogin() {
        tabPane.getSelectionModel().select(10);
        logoutButton.setVisible(false);
    }
    @FXML
    protected void goToAddPerson() {
        tabPane.getSelectionModel().select(0);
    }

    @FXML
    protected void onSavePerson() {
        if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || birthDay.getValue() == null) {
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
        currentTab = 1;
        indexVehicle = index;
        Vehicle vehicle = manager.getVehicle(index);
        vehicleName.setText(vehicle.getVehicleNumber());
        vehicleBrand.setText(vehicle.getProducerName());
        currentVehicle = vehicle;

        Image image = new Image(vehicle.getImgUrl());
        imageView.setImage(image);

        PersonSelection.getItems().clear();

        EventHandler<ActionEvent> eventAdd = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                tabPane.getSelectionModel().select(0);

            }
        };
        MenuItem menuItem = new MenuItem("Add new Costumer");
        menuItem.setOnAction(eventAdd);
        PersonSelection.getItems().add(menuItem);


        ArrayList<Person> persons = manager.getCustomerList();
        for (int i = 0; i < persons.size(); i++) {
            EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    personSelected.setText(((MenuItem) e.getSource()).getText() + " selected");
                    selectedPerson = Integer.parseInt(((MenuItem) e.getSource()).getId());
                }
            };

            menuItem = new MenuItem(persons.get(i).getFirstName() + " " + persons.get(i).getLastName());
            menuItem.setOnAction(event1);
            menuItem.setId("" + i);

            PersonSelection.getItems().add(menuItem);
        }
    }

    @FXML
    protected void onRent() throws MinorAgeException {
        ;
        if (startDate.getValue() == null || endDate.getValue() == null || selectedPerson == -1) {
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

                linkToPDF.setOnAction(e -> {
                    String url = "https://valentin-nussbaumer.com/java/api/rent/pdf.php?usr=" + person.getFirstName() + "%20" + person.getLastName() + "&prod=" + vehicle.getProducerName() + "&sDate=" + startDate.getValue().toString() + "&eDate=" + endDate.getValue().toString() + "&model=" + vehicle.getVehicleNumber() + "&img=" + vehicle.getImgUrl() + "";
                    url = url.replace(" ", "%20");
                    try {
                        Desktop.getDesktop().browse(new URI(url));
                    } catch (IOException | URISyntaxException ex) {
                        ex.printStackTrace();
                    }
                });
            } else {
                showAlert(msg);
            }
        }
    }

    @FXML
    protected void onLoadDeny() {

        PersonToDeny.getItems().clear();

        ArrayList<Person> persons = manager.getCustomerList();
        for (int i = 0; i < persons.size(); i++) {
            EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    denyPersonSelected.setText(((MenuItem) e.getSource()).getText() + " selected");
                    selectedPersonDeny = Integer.parseInt(((MenuItem) e.getSource()).getId());
                }
            };

            MenuItem menuItem = new MenuItem(persons.get(i).getFirstName() + " " + persons.get(i).getLastName());
            menuItem.setOnAction(event2);
            menuItem.setId("" + i);

            PersonToDeny.getItems().add(menuItem);
        }
        tabPane.getSelectionModel().select(6);
    }


    @FXML
    protected void addToDenyList() {
        if (selectedPersonDeny == -1) {
            showAlert("Not all fields a filled up");
        } else {
            Person person = manager.getPerson(selectedPersonDeny);
            if (manager.checkIfOnDenyList(person)) {
                currentTab = 6;
                showAlert("This customer is already deny listed");
            } else {
                manager.addPersonToDenyList(person);
                if (manager.checkIfContracts(person)) {
                    currentTab = 5;
                    showAlert("The existing contract from that customer will be kept");
                } else {
                    tabPane.getSelectionModel().select(5);
                }
            }
        }
    }

    @FXML
    protected void addVehicle() {
        if (producerNameNew.getText().isEmpty() || modelNumberNew.getText().isEmpty() || colorNew.getText().isEmpty() || nameOfVehicleNew.getText().isEmpty() || minAgeNew.getText().isEmpty() || imgUrlNew.getText().isEmpty()) {
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
        if (indexVehicle < manager.getVehicleListSize() - 1) {
            onLoadVehicle(indexVehicle + 1);
        } else {
            showAlert("Can't go further");
        }
    }

    @FXML
    protected void lastVehicle() {
        if (indexVehicle > 0) {
            onLoadVehicle(indexVehicle - 1);
        } else {
            showAlert("Can't go back");
        }
    }

    @FXML
    protected void nextVehicleEdit() {
        if (indexVehicle < manager.getVehicleListSize() - 1) {
            onLoadVehicleEdit(indexVehicle + 1);
        } else {
            showAlert("Can't go further");
        }
    }

    @FXML
    protected void lastVehicleEdit() {
        if (indexVehicle > 0) {
            onLoadVehicleEdit(indexVehicle - 1);
        } else {
            showAlert("Can't go back");
        }
    }

    @FXML
    protected void onLoadVehicleEdit(int index) {
        indexVehicle = index;
        Vehicle vehicle = manager.getVehicle(index);
        producerNameEdit.setText(vehicle.getProducerName());
        nameOfVehicleEdit.setText(vehicle.getVehicleNumber());
        modelNumberEdit.setText(vehicle.getModelNumber() + "");
        colorEdit.setText(vehicle.getColor());
        minAgeEdit.setText(vehicle.getMinAge() + "");
        imgUrlEdit.setText(vehicle.getImgUrl());
    }

    @FXML
    protected void updateVehicle() {
        if (producerNameEdit.getText().isEmpty() || modelNumberEdit.getText().isEmpty() || colorEdit.getText().isEmpty() || nameOfVehicleEdit.getText().isEmpty() || minAgeEdit.getText().isEmpty() || imgUrlEdit.getText().isEmpty()) {
            showAlert("Not all fields a filled up");
        } else {
            int modelNumberInt = Integer.parseInt(modelNumberEdit.getText());
            int minAgeInt = Integer.parseInt(minAgeEdit.getText());

            manager.updateVehicle(indexVehicle, producerNameEdit.getText(), modelNumberInt, colorEdit.getText(), nameOfVehicleEdit.getText(), minAgeInt, imgUrlEdit.getText());
            tabPane.getSelectionModel().select(5);
        }
    }

    @FXML
    protected void deleteVehicle() {
        if (manager.getVehicleListSize() < 2) {
            showAlert("Please leave one Behind");
        } else {
            manager.deleteVehicle(indexVehicle);
            tabPane.getSelectionModel().select(5);
            indexVehicle = 0;
        }
    }


    @FXML
    protected void rentMore() {
        tabPane.getSelectionModel().select(1);
        currentTab = 1;
        onLoadVehicle(0);
    }

    @FXML
    protected void showAlert(String message) {
        alertMessage.setText(message);
        tabPane.getSelectionModel().select(3);
    }

    @FXML
    protected void goBackToTab() {
        tabPane.getSelectionModel().select(currentTab);
    }

    @FXML
    protected void goToLogin() {
        tabPane.getSelectionModel().select(4);
    }

    @FXML
    protected void login() {
        if (adminPassword.equals(adminPasswordField.getText())) {
            tabPane.getSelectionModel().select(5);
        } else {
            currentTab = 5;
            showAlert("Wrong Password");
        }
        adminPasswordField.clear();
    }

    @FXML
    protected void goToAddVehicle() {
        tabPane.getSelectionModel().select(7);
    }



    @FXML
    protected void goToEditVehicle() {
        currentTab = 8;
        tabPane.getSelectionModel().select(8);
        onLoadVehicleEdit(0);
    }

    @FXML
    protected void exitAdmin() {
        currentTab = 1;
        tabPane.getSelectionModel().select(1);
        onLoadVehicle(0);
    }

    @FXML
    protected void addPersonAdmin() {
        tabPane.getSelectionModel().select(0);
    }

    @FXML
    protected void onEditPerson() {
        if (firstNameEdit.getText().isEmpty() || lastNameEdit.getText().isEmpty() || birthDayEdit.getValue() == null) {
            showAlert("Not all fields a filled up");
        } else {
            manager.updatePerson(indexPerson, firstNameEdit.getText(), lastNameEdit.getText(), birthDayEdit.getValue());
            firstName.clear();
            lastName.clear();
            birthDay.getEditor().clear();

            currentTab = 5;
            tabPane.getSelectionModel().select(5);
        }
    }

    @FXML
    protected void deletePerson() {
        manager.deletePerson(indexPerson);
        tabPane.getSelectionModel().select(5);
        indexPerson = 0;
        firstName.clear();
        lastName.clear();
        birthDay.getEditor().clear();
}

    @FXML
    protected void onLoadPersonEdit(int index) {
        indexPerson = index;
        try {
            Person person = manager.getPerson(index);

            firstNameEdit.setText(person.getFirstName());
            lastNameEdit.setText(person.getLastName());
            birthDayEdit.setValue(person.getBirthday());
        } catch (Exception e){
            currentTab = 0;
            showAlert("Create a Customer first");
        }
    }

    @FXML
    protected void goToEditPerson() {
        currentTab = 9;
        tabPane.getSelectionModel().select(9);
        onLoadPersonEdit(0);
    }

    @FXML
    protected void nextPersonEdit() {
        if (indexPerson < manager.getCustomerList().size() - 1) {
            onLoadPersonEdit(indexPerson + 1);
        } else {
            showAlert("Can't go further");
        }
    }

    @FXML
    protected void lastPersonEdit() {
        if (indexPerson > 0) {
            onLoadPersonEdit(indexPerson - 1);
        } else {
            showAlert("Can't go back");
        }
    }


}