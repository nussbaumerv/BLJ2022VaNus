package com.example.hellofx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class HelloController {

    @FXML
    private Label supTitle;
    @FXML
    private TextField preName;

    @FXML
    private TextField surName;
    @FXML
    private TextField email;

    @FXML
    private Button cancelButton;

    @FXML
    private VBox editOptions;

    @FXML
    private HBox navOptions;

    private int index = 0;

    private boolean creating = false;


    private PersonManger pmgr = new PersonManger();

    @FXML
    protected void onEdit() {
        preName.setEditable(true);
        surName.setEditable(true);
        email.setEditable(true);
        editMode();
    }

    @FXML
    protected void onDelete() {
        index = pmgr.deletePerson(index);
        setValues();
    }

    @FXML
    protected void onSave() {
        if (!(preName.getText().isEmpty() || surName.getText().isEmpty() || email.getText().isEmpty())) {
            preName.setEditable(false);
            surName.setEditable(false);
            email.setEditable(false);


            pmgr.setPerson(index, preName.getText(), surName.getText(), email.getText());

            creating = false;
            navMode();
        } else{
            supTitle.setText("Please fill everything out");
        }

    }

    @FXML
    protected void onCancel() {
        preName.setEditable(false);
        surName.setEditable(false);
        email.setEditable(false);

        if (creating) {
            creating = false;
            onDelete();
        }
        navMode();
    }

    @FXML
    protected void setValues() {
        preName.setText(pmgr.getFirstname(index));
        surName.setText(pmgr.getName(index));
        email.setText(pmgr.getEmail(index));
        String state = index + 1 + " / " + pmgr.getSize();
        supTitle.setText(state);
    }

    @FXML
    protected void onAdd() {
        index = pmgr.addPeopleToList();
        setValues();

        preName.setEditable(true);
        surName.setEditable(true);
        email.setEditable(true);

        creating = true;
        editMode();
    }

    @FXML
    protected void editMode() {
        navOptions.setVisible(false);
        editOptions.setVisible(true);
        cancelButton.setVisible(true);

        if(creating){
            supTitle.setText("Add Person");
        } else{
            supTitle.setText("Edit Person");
        }

    }

    @FXML
    protected void navMode() {
        editOptions.setVisible(false);
        navOptions.setVisible(true);
        String state = index + 1 + " / " + pmgr.getSize();
        supTitle.setText(state);
    }

    @FXML
    protected void moveNext() {
        if (index + 1 < pmgr.getSize()) {
            index++;
            setValues();
        } else{
            supTitle.setText("Can't go further");
        }
    }

    @FXML
    protected void moveLast() {
        if (index + 1 > 1) {
            index--;
            setValues();
        } else{
            supTitle.setText("Can't go further");
        }
    }


}