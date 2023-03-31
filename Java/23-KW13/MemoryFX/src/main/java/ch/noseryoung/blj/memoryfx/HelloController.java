package ch.noseryoung.blj.memoryfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class HelloController {

    Memory open1 = null;
    Button bopen1 = null;
    Memory open2 = null;
    Button bopen2 = null;

    MemoryManager manager;

    Properties langProps;

    public void initialize() throws IOException {
        manager = new MemoryManager();
        setLanguage("german");
    }

    public void setLanguage(String language) throws IOException {
        String langConfigPath = "C:\\Source\\BLJ2022VaNus\\Java\\23-KW13\\MemoryFX\\src\\main\\resources\\ch\\noseryoung\\blj\\memoryfx\\englisch.properties";

        langProps = new Properties();
        langProps.load(new FileInputStream(langConfigPath));
    }

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
        } else if (memory.getIcon().equals(open1.getIcon()) && ! memory.getId().equals(open1.getId())) {
            button.setDisable(true);
            bopen1.setDisable(true);

            setAllNull();
        } else if(!open1.getId().equals(memory.getId())){
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


}