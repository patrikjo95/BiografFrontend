package com.example.biograffrontend2.Controllers;

import com.example.biograffrontend2.Application;
import com.example.biograffrontend2.ConnectionManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class adminLoginController {

    @FXML
    public TextField userNameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label loginErrorLabel;


    public String response;
    public String tom = "@tom";


    /**
     * Tar input från userNameField och passwordField och skickar till backend för att kontrollera mot databasen,
     * response kontrolleras då för felhantering.
     * @param event
     * @throws IOException
     */
    @FXML
    protected void loginButtonClicked(ActionEvent event) throws IOException {
        Platform.runLater(() -> {
            ConnectionManager cm = new ConnectionManager();
            String username = userNameField.getText();
            String password = passwordField.getText();

            response = cm.sendGetRequest("staff_login/?check_username=" + username + "&check_password=" + password + "&@tom=" + tom);
            //adminLoginErrorLabel.setVisible(false);

            if(response.contains("Incorrect")){
                loginErrorLabel.setVisible(true);
                loginErrorLabel.setText("Incorrect login");
                userNameField.clear();
                passwordField.clear();
            }else{
                Application m = new Application();
                try {
                    m.changeScene("adminSchema.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        });

    }

    @FXML
    protected void closeButtonClicked() {
        System.exit(0);

    }

    public void adminLoginBackButtonClicked(ActionEvent event) throws IOException {
        Application m = new Application();
        m.changeScene("mainMenu.fxml");

    }
}
