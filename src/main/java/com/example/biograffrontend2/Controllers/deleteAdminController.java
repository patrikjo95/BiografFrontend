package com.example.biograffrontend2.Controllers;

import com.example.biograffrontend2.Application;
import com.example.biograffrontend2.ConnectionManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class deleteAdminController {

    @FXML
    private TextField userNameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label loginErrorLabel;



    private String response;
    private final String tom = "@tom";


    @FXML
    public void deleteAdminButtonClicked(ActionEvent event){
        Platform.runLater(() -> {
            ConnectionManager cm = new ConnectionManager();
            String username = userNameField.getText();
            String password = passwordField.getText();

            response = cm.sendGetRequest("deleteStaff/?username=" + username + "&password=" + password + "&@tom=" + tom);

            if(response.contains("Error")){
                loginErrorLabel.setVisible(true);
                loginErrorLabel.setText("User could not be deleted, please try again");
                userNameField.clear();
                passwordField.clear();
            }else{
                loginErrorLabel.setVisible(true);
                loginErrorLabel.setText("Admin successfully deleted");
                userNameField.clear();
                passwordField.clear();
            }
        });
    }

    @FXML
    protected void closeButtonClicked() {
        System.exit(0);

    }

    @FXML
    protected void adminLoginBackButtonClicked(ActionEvent event)throws IOException {
        Application m = new Application();
        m.changeScene("mainMenu.fxml");
    }
}
