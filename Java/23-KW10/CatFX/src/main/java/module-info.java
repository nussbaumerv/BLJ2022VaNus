module com.example.catfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.catfx to javafx.fxml;
    exports com.example.catfx;
}