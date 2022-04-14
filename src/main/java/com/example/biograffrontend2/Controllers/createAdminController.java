package com.example.biograffrontend2.Controllers;

import com.example.biograffrontend2.Application;
import com.example.biograffrontend2.ConnectionManager;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.io.IOException;
import java.util.Objects;

public class createAdminController {

    @FXML
    private TextField adminNameField;
    @FXML
    private TextField adminPhoneField;
    @FXML
    private TextField adminUsernameField;
    @FXML
    private TextField adminPassword1Field;
    @FXML
    private TextField adminPassword2Field;
    @FXML
    private Label adminLoginErrorLabel;
    @FXML


    public String response;
    public String tom = "@tom";

    @FXML
    protected void createAdminBackButtonClicked(ActionEvent event)throws IOException {
        Application m = new Application();
        m.changeScene("adminSchema.fxml");
    }

    @FXML
    private void createAdminButtonClicked(ActionEvent event){
        Platform.runLater(() -> {
            ConnectionManager cm = new ConnectionManager();
            String adminName = adminNameField.getText();
            String phone = adminPhoneField.getText();
            String username = adminUsernameField.getText();
            String password = adminPassword1Field.getText();


                if (Objects.equals(adminPassword1Field.getText(), adminPassword2Field.getText())) {

                    response = cm.sendGetRequest("add_staff/?new_name=" + adminName + "&new_phonenumber=" + phone + "&new_username=" + username + "&new_password=" + password + "&@tom=" + tom);

                    System.out.println("response: " + response);
                    adminLoginErrorLabel.setVisible(false);

                    if (response.contains("number")) {
                        adminLoginErrorLabel.setText("Incorrect phone number");
                        adminLoginErrorLabel.setVisible(true);
                        //System.out.println("Fel telefonnummer");

                    } else if (response.contains("username")) {
                        adminLoginErrorLabel.setText("That user already exists");
                        adminLoginErrorLabel.setVisible(true);
                        //System.out.println("duplicate username");

                    } else if (response.contains("password")) {
                        adminLoginErrorLabel.setText("Incorrect password, must be 8 characters long");
                        adminLoginErrorLabel.setVisible(true);


                    } else if (adminPassword1Field.getText().equals(adminPassword2Field.getText())) {
                        Application m = new Application();
                        try {
                            m.changeScene("adminSchema.fxml");
                            //loginUserLabel.setText("Inloggad som: " + userNameField.getText());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                } else {
                    adminLoginErrorLabel.setVisible(true);
                    adminLoginErrorLabel.setText("Passwords does not match, please try again.");
                }

        });

    }

    @FXML
    protected void closeButtonClicked() {
        System.exit(0);

    }
}
