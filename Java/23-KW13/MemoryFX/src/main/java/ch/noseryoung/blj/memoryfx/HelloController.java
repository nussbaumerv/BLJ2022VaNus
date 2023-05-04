package ch.noseryoung.blj.memoryfx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HelloController {

    Memory open1 = null;
    Button bopen1 = null;
    Memory open2 = null;
    Button bopen2 = null;

    MemoryManager manager;

    Properties langProps;

    int foundMemory = 0;


    @FXML
    private Button r0c0;

    @FXML
    private Button r0c1;

    @FXML
    private Button r0c2;

    @FXML
    private Button r0c3;


    @FXML
    private Button r1c0;

    @FXML
    private Button r1c1;

    @FXML
    private Button r1c2;

    @FXML
    private Button r1c3;

    @FXML
    private Button r2c0;

    @FXML
    private Button r2c1;

    @FXML
    private Button r2c2;

    @FXML
    private Button r2c3;

    @FXML
    private Button r3c0;

    @FXML
    private Button r3c1;

    @FXML
    private Button r3c2;

    @FXML
    private Button r3c3;

    @FXML
    private Button start;

    @FXML
    private Label welcomeText;

    @FXML
    private Button alertButton;

    @FXML
    private Label alertMsg;

    @FXML
    private TabPane tabPane;

    @FXML
    private MenuButton language;

    public void initialize() throws IOException {
        manager = new MemoryManager();
        setLanguage("englisch");
    }

    public void enableTextLanguage() {
        welcomeText.setText(langProps.getProperty("introMessage"));
        start.setText(langProps.getProperty("startButtonText"));
        language.setText(langProps.getProperty("languageSwitch"));
    }

    public void setLanguage(String language) throws IOException {
        try {
            String langConfigPath = "C:\\Source\\BLJ2022VaNus\\Java\\23-KW13\\MemoryFX\\src\\main\\resources\\ch\\noseryoung\\blj\\memoryfx\\" + language + ".properties";

            langProps = new Properties();
            langProps.load(new FileInputStream(langConfigPath));
        } catch (Exception e) {
            System.out.println("Sprache konnte nicht geändert werden");
        }
        enableTextLanguage();
    }


    @FXML
    private void onHelloButtonClick(ActionEvent event) {
        if (open1 != null && open2 != null) {
            closeOpen();
        }
        Button button = (Button) event.getSource();
        Memory memory = manager.getMemory(button.getId());
        ImageView view = new ImageView(memory.getIcon());
        view.setFitHeight(40);
        view.setFitWidth(30);
        view.setPreserveRatio(false);
        button.setGraphic(view);

        if (open1 == null) {
            open1 = memory;
            bopen1 = button;
        } else if (memory.getIcon().equals(open1.getIcon()) && !memory.getId().equals(open1.getId())) {
            button.setDisable(true);
            bopen1.setDisable(true);

            foundMemory += 2;
            System.out.println(foundMemory);

            if (foundMemory == manager.getFiledSize()) {
                System.out.println("Won");
                finishedMemory();
            }

            setAllNull();
        } else if (!open1.getId().equals(memory.getId())) {
            open2 = memory;
            bopen2 = button;
        }
    }

    @FXML
    private void setAllNull() {
        open1 = null;
        open2 = null;
        bopen1 = null;
        bopen2 = null;
    }


    @FXML
    private void closeOpen() {
        bopen1.setGraphic(null);
        bopen2.setGraphic(null);
        bopen1.setDisable(false);
        bopen2.setDisable(false);

        setAllNull();
    }

    @FXML
    private EventHandler<ActionEvent> moveToMain() {
        tabPane.getSelectionModel().select(1);
        return null;
    }

    @FXML
    private void setLanguageToGerman() throws IOException {
        setLanguage("german");
    }

    @FXML
    private void setLanguageToEnglish() throws IOException {
        setLanguage("englisch");
    }

    @FXML
    private void finishedMemory() {
        alertMsg.setText(langProps.getProperty("wonMessage"));
        alertButton.setText(langProps.getProperty("wonButton"));
        tabPane.getSelectionModel().select(2);
        cleanFields();
    }

    @FXML
    private void cleanFields() {
        manager = new MemoryManager();

        r0c0.setDisable(false);
        r0c0.setGraphic(null);

        r0c1.setDisable(false);
        r0c1.setGraphic(null);

        r0c2.setDisable(false);
        r0c2.setGraphic(null);

        r0c3.setDisable(false);
        r0c3.setGraphic(null);

        r1c0.setDisable(false);
        r1c0.setGraphic(null);

        r1c1.setDisable(false);
        r1c1.setGraphic(null);

        r1c2.setDisable(false);
        r1c2.setGraphic(null);

        r1c3.setDisable(false);
        r1c3.setGraphic(null);

        r2c0.setDisable(false);
        r2c0.setGraphic(null);

        r2c1.setDisable(false);
        r2c1.setGraphic(null);

        r2c2.setDisable(false);
        r2c2.setGraphic(null);

        r2c3.setDisable(false);
        r2c3.setGraphic(null);

        r3c0.setDisable(false);
        r3c0.setGraphic(null);

        r3c1.setDisable(false);
        r3c1.setGraphic(null);

        r3c2.setDisable(false);
        r3c2.setGraphic(null);

        r3c3.setDisable(false);
        r3c3.setGraphic(null);

/*
        @FXML
        private Button r0c1;

        @FXML
        private Button r0c2;

        @FXML
        private Button r0c3;


        @FXML
        private Button r1c0;

        @FXML
        private Button r1c1;

        @FXML
        private Button r1c2;

        @FXML
        private Button r1c3;

        @FXML
        private Button r2c0;

        @FXML
        private Button r2c1;

        @FXML
        private Button r2c2;

        @FXML
        private Button r2c3;

        @FXML
        private Button r3c0;

        @FXML
        private Button r3c1;

        @FXML
        private Button r3c2;

        @FXML
        private Button r3c3;

 */


    }


}