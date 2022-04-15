package com.example.biograffrontend2.Controllers;

import com.example.biograffrontend2.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class adminSchemaController {

    @FXML
    private Label workingLabel;
    @FXML
    private DatePicker datePicker;



    public List<LocalDate> exempelDagar = new ArrayList<>();


    @FXML
    protected void deleteAdminMenuItemClicked(ActionEvent event)throws IOException{
        Application m = new Application();
        m.changeScene("deleteAdmin.fxml");
    }

    @FXML
    protected void closeButtonClicked() {
        System.exit(0);

    }


    /**
     * denna metod skall ta schemat från databas och populera rätt datumrutor i datePicker genom att lägga in dessa i listan exempelDagar.
     * fungerar ej ännu.
     */
    @FXML
    private void getDate() {
        Platform.runLater(()->{
            workingLabel.setVisible(true);

            exempelDagar = FXCollections.observableArrayList();

            exempelDagar.add(LocalDate.of(2022, Month.APRIL, 12));
            exempelDagar.add(LocalDate.of(2022, Month.APRIL, 8));
            exempelDagar.add(LocalDate.of(2022, Month.APRIL, 28));
            exempelDagar.add(LocalDate.of(2022, Month.APRIL, 1));


            LocalDate localDate = datePicker.getValue();
            workingLabel.setText(String.valueOf(localDate));



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
            });
        });

    }

    @FXML
    protected void addMovieButtonClicked(ActionEvent event) throws IOException {
        Application m = new Application();
        m.changeScene("addMovie.fxml");
    }

    @FXML
    protected void adminLogoutButtonClicked(ActionEvent event) throws IOException {
        Application m = new Application();
        m.changeScene("adminLogin.fxml");
    }

    @FXML
    protected void addAdminButtonClicked(ActionEvent event) throws IOException {
        Application m = new Application();
        m.changeScene("createAdmin.fxml");
    }


}
