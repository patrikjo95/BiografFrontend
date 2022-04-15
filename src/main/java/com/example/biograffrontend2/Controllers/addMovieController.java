package com.example.biograffrontend2.Controllers;

import com.example.biograffrontend2.*;
import com.google.gson.*;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Arrays;

public class addMovieController {
    @FXML
    private TableView<Schedule> tableView;
    @FXML
    private TableColumn<Schedule, String> movieNameColumn;
    @FXML
    private TableColumn<Schedule, String> movieTimeColumn;
    @FXML
    private TableColumn<Schedule, String> movieTheaterColumn;
    @FXML
    private TableColumn<Schedule, String> seatsAvailableColumn;
    @FXML
    private Button refresh;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfTime;
    @FXML
    private TextField tfTheater;

    public String response;
    public ObservableList<Schedule> table = FXCollections.observableArrayList();


    /**
     *Sätter tfName till den valda filmen i tabellen, detta textfield är ej redigerbart.
     */
    @FXML
    protected void populateTextField() {
        try {
            tfName.setText(tableView.getSelectionModel().getSelectedItem().getA());


        }
        catch (NullPointerException npe) {
        }
    }

    private void clearColums() {
        showTable();
        tfName.clear();
        tfTime.clear();
        tfTheater.clear();
    }


    @FXML
    protected void addMovieBackButtonClicked(ActionEvent event)throws IOException {
        Application m = new Application();
        m.changeScene("adminSchema.fxml");

    }

    @FXML
    protected void closeButtonClicked() {
        System.exit(0);

    }

    /**
     * populerar tableview med försatta värden med de filmer vi har i vår databas.
     * @return
     */
    @FXML
    public ObservableList<Schedule> populateTable(){
        ObservableList<Schedule> table = FXCollections.observableArrayList();

        Schedule brokebackmountain = new Schedule("BrokebackMountain", "", "");
        Schedule spiderman = new Schedule("Spiderman", "", "");
        Schedule theGentlemen = new Schedule("TheGentlemen", "", "");
        Schedule snatch = new Schedule("Snatch", "", "");

        table.add(brokebackmountain);
        table.add(spiderman);
        table.add(theGentlemen);
        table.add(snatch);

        return table;

    }

    @FXML
    public void showTable(){
        ObservableList<Schedule> list = populateTable();

        movieNameColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("a"));
        movieTimeColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("b"));
        movieTheaterColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("c"));

        tableView.setItems(list);

    }

    @FXML
    protected void refreshButton(ActionEvent event) throws IOException {
        showTable();

    }

    /**
     * tar input från textfields och skickar till backend för att lägga till film i databasen.
     * @param event
     * @throws IOException
     */
    @FXML
    protected void addButton(ActionEvent event) throws IOException {
        Platform.runLater(()->{
            ConnectionManager cm = new ConnectionManager();

            Gson gson = new Gson();
            response = cm.sendGetRequest("add_movie/?new_movie_name=" + tfName.getText() + "&new_movie_datetime=" + tfTime.getText() + "&which_theater_id=" + tfTheater.getText());

            String response2;
            response2 = cm.sendGetRequest("return_movie_schema/?pick_movie_name=" + tfName.getText());

            System.out.println(response2);

            String trimmedResponse = trimResponse(response2);

            System.out.println("trimmed version: " + trimmedResponse);

            Movies[] movieArray = gson.fromJson(trimmedResponse, Movies[].class);
            System.out.println("movieArray: " + movieArray[0]);
            System.out.println(Arrays.toString(movieArray));

            for(int i = 0; i < movieArray.length; i++){
                Schedule index;



            }

            clearColums();
            showTable();

        });

    }

    @FXML
    protected void deleteButton(ActionEvent event) throws IOException {

        clearColums();
        showTable();
    }


    /**
     * trimmar ner våran json-response så att resultset texten inte finns framför och bakom själva strängen.
     * @param response
     * @return
     */
    public String trimResponse(String response){
        int first = 0;
        int last = 0;
        for(int i = 0; i<response.length();i++){
            if(response.charAt(i) == '['){
                first = i;
            }
            if(response.charAt(i) == ']'){
                last = i;
            }
        }
        String trimmedStringResponse = response.substring(first,last+1);

        return trimmedStringResponse;
    }

}

