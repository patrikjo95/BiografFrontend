module com.example.biograffrontend2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.google.gson;


    opens com.example.biograffrontend2 to javafx.fxml;
    exports com.example.biograffrontend2;
    exports com.example.biograffrontend2.Controllers;
    opens com.example.biograffrontend2.Controllers to javafx.fxml;
}