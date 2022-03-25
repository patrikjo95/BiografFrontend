package com.example.biograffrontend2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {
    @FXML
    private TextField passwordField;
    @FXML
    private TextField userNameField;
    @FXML
    private Label loginErrorLabel;
    @FXML
    private Label loginUserLabel;

    public Controller() {
    }

    @FXML
    protected void closeButtonClicked() {
        System.exit(0);
    }

    @FXML
    protected void bokaButtonClicked() throws IOException {
    }

    @FXML
    protected void adminButtonClicked(ActionEvent event) throws IOException {
        Application a = new Application();
        a.changeScene("adminLogin.fxml");

    }

    @FXML
    protected void loginButtonClicked(ActionEvent event) throws IOException {
        Application m = new Application();
        String loggedInUser = this.userNameField.getText();
        /*if (loggedInUser.equals("sexy") && this.passwordField.getText().equals("1234")) {
            m.changeScene("schema.fxml");
            //this.loginUserLabel.setText("Inloggad som: " + loggedInUser);
        } else {
            this.loginErrorLabel.setText("Puder dont accept your request ");
            this.loginErrorLabel.setVisible(true);
        }*/
        m.changeScene("schema.fxml");
    }

    @FXML
    protected void adminLogoutButtonClicked(ActionEvent event)throws IOException{
        Application m = new Application();
        m.changeScene("adminLogin.fxml");
    }

    @FXML
    public void addAdminButtonClicked(ActionEvent event)throws IOException {
        Application m = new Application();
        m.changeScene("createAdmin.fxml");
    }

    @FXML
    public void addMovieButtonClicked(ActionEvent event)throws IOException {
        Application m = new Application();
        m.changeScene("addMovie.fxml");
    }

    @FXML
    public void movieButton1Clicked(ActionEvent event)throws IOException {
        System.out.println("DU FÅR INTE KOLLA PÅ SPOODERMAN EDWIN!!!!!!!!!!!");
    }

}