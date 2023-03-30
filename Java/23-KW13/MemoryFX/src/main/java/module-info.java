module ch.noseryoung.blj.memoryfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens ch.noseryoung.blj.memoryfx to javafx.fxml;
    exports ch.noseryoung.blj.memoryfx;
}