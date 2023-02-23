module com.example.docsview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.docsview to javafx.fxml;
    exports com.example.docsview;
}