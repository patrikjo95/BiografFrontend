package com.example.biograffrontend2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

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
    @FXML
    private ImageView brokebackImage, spidermanImage, snatchImage, theGentlemanImage;


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
    protected void addAdminButtonClicked(ActionEvent event)throws IOException {
        Application m = new Application();
        m.changeScene("createAdmin.fxml");
    }

    @FXML
    protected void addMovieButtonClicked(ActionEvent event)throws IOException {
        Application m = new Application();
        m.changeScene("addMovie.fxml");
    }

    @FXML
    protected void movieButtonClicked(MouseEvent event)throws IOException {
        Application m = new Application();
        m.changeScene("movieSchedule.fxml");
    }

    @FXML
    protected void movieMouseEnteredEvent(MouseEvent event){
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(+0.1);
        ImageView currentImage = (ImageView) event.getSource();
        currentImage.setEffect(colorAdjust);

    }

    @FXML
    protected void movieMouseExitedEvent(MouseEvent event){
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.1);
        ImageView currentImage = (ImageView) event.getSource();
        currentImage.setEffect(colorAdjust);
    }

    @FXML
    protected void movieSchemaBackButtonClicked(ActionEvent event)throws IOException{
        Application m = new Application();
        m.changeScene("movieMenu.fxml");
    }



}