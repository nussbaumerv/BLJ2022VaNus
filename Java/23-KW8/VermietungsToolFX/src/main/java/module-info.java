module com.example.vermietungstoolfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.vermietungstoolfx to javafx.fxml;
    exports com.example.vermietungstoolfx;
    exports com.example.vermietungstoolfx.vehicles;
    opens com.example.vermietungstoolfx.vehicles to javafx.fxml;
}