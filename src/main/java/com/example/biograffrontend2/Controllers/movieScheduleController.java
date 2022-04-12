package com.example.biograffrontend2.Controllers;

import com.example.biograffrontend2.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class movieScheduleController {

    @FXML
    protected void movieSchemaBackButtonClicked(ActionEvent event) throws IOException {
        Application m = new Application();
        m.changeScene("mainMenu.fxml");
    }

    @FXML
    protected void closeButtonClicked() {
        System.exit(0);

    }
}
