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
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private Label loginErrorLabel;


    public String response;
    public String tom = "@tom";



    @FXML
    protected void loginButtonClicked(ActionEvent event) throws IOException {
        /*Platform.runLater(() -> {
            ConnectionManager cm = new ConnectionManager();
            String username = usernameField.getText();
            String password = passwordField.getText();

            response = cm.sendGetRequest("staffLogin/?username=" + username + "&password=" + password + "&@tom=" + tom);
            //adminLoginErrorLabel.setVisible(false);

            if(response.contains("Incorrect")){
                loginErrorLabel.setVisible(true);
                loginErrorLabel.setText("Incorrect login");
                usernameField.clear();
                passwordField.clear();
            }else{
                Application m = new Application();
                try {
                    m.changeScene("adminSchema.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });*/
        Application m = new Application();
        m.changeScene("adminSchema.fxml");


            /*exempelDagar = FXCollections.observableArrayList();

            exempelDagar.add(LocalDate.of(2022, Month.MARCH, 30));
            exempelDagar.add(LocalDate.of(2022, Month.MARCH, 29));
            exempelDagar.add(LocalDate.of(2022, Month.MARCH, 28));
            exempelDagar.add(LocalDate.of(2022, Month.APRIL, 1));


            datePicker.setDayCellFactory(new Callback<>() {
                @Override
                public DateCell call(DatePicker param) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);

                            if (!empty && item != null) {
                                if (exempelDagar.contains(item)) {
                                    this.setStyle("-fx-background-color: pink");
                                }
                            }
                        }
                    };
                }
            });*/

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
