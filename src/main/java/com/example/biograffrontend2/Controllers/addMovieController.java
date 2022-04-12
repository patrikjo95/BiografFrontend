package com.example.biograffrontend2.Controllers;

import com.example.biograffrontend2.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class addMovieController {

    @FXML
    protected void addMovieBackButtonClicked(ActionEvent event)throws IOException {
        Application m = new Application();
        m.changeScene("adminSchema.fxml");
    }

    @FXML
    protected void closeButtonClicked() {
        System.exit(0);

    }
}
