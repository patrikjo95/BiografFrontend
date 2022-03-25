module com.example.biograffrontend2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.biograffrontend2 to javafx.fxml;
    exports com.example.biograffrontend2;
}