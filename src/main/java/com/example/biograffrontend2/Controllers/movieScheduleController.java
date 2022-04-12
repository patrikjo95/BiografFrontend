package com.example.biograffrontend2.Controllers;

import com.example.biograffrontend2.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class movieScheduleController {

    @FXML
    private Button refreshButton;
    @FXML
    private Button confirmButton;

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
