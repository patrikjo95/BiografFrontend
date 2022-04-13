package com.example.biograffrontend2.Controllers;

import com.example.biograffrontend2.*;
import com.google.gson.*;
import javafx.application.Platform;
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


    @FXML
    protected void populateTextField() {
        try {
            tfName.setText(tableView.getSelectionModel().getSelectedItem().getA());
            tfTime.setText(tableView.getSelectionModel().getSelectedItem().getB());
            tfTheater.setText(tableView.getSelectionModel().getSelectedItem().getC());

        }
        catch (NullPointerException npe) {
        }
    }

    private void clearColums() {
        //showTable();
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

    @FXML
    public ObservableList<Schedule> populateTable(){
        ObservableList<Schedule> table = FXCollections.observableArrayList();
        //Platform.runLater(()->{


        /*ConnectionManager cm = new ConnectionManager();
        response = cm.sendGetRequest("addMovie/?movie_name=" + tfName.getText() + "&movie_datetime=" + tfTime.getText() + "&theater_id_order=" + tfTheater.getText());

        String response2;
        response2 = cm.sendGetRequest("returnMovieSchema/?Moviename=" + tfName.getText());
        //parseMovies(response2);
        System.out.println(response2);*/

        Schedule brokebackmountain = new Schedule("BrokebackMountain", "null", "null");
        Schedule spiderman = new Schedule("Spiderman", "null", "null");
        Schedule theGentlemen = new Schedule("TheGentlemen", "null", "null");
        Schedule snatch = new Schedule("Snatch", "null", "null");

        table.add(brokebackmountain);
        table.add(spiderman);
        table.add(theGentlemen);
        table.add(snatch);

        /*ConnectionManager cm = new ConnectionManager();

        Gson gson = new Gson();
        response = cm.sendGetRequest("addMovie/?movie_name=" + tfName.getText() + "&movie_datetime=" + tfTime.getText() + "&theater_id_order=" + tfTheater.getText());

        String response2;
        response2 = cm.sendGetRequest("returnMovieSchema/?Moviename=" + tfName.getText());

        System.out.println(response2);

        String trimmedResponse = trimResponse(response2);

        System.out.println("trimmed version: " + trimmedResponse);

        Movies[] movieArray = gson.fromJson(trimmedResponse, Movies[].class);
        System.out.println("movieArray: " + movieArray[0]);
        System.out.println("first movieName: " + movieArray[1].getMovie_name());
        System.out.println(Arrays.toString(movieArray));

            for (Movies movies : movieArray) {
                Schedule insert = new Schedule(movies.getMovie_name(), movies.getMovie_datetime(), movies.getTheater_id(), movies.getSeats_avalible());

                table.add(insert);
            }
        });*/

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

    @FXML
    protected void addButton(ActionEvent event) throws IOException {
        Platform.runLater(()->{
            ObservableList<Schedule> table = FXCollections.observableArrayList();

            ConnectionManager cm = new ConnectionManager();

            Gson gson = new Gson();
            response = cm.sendGetRequest("addMovie/?movie_name=" + tfName.getText() + "&movie_datetime=" + tfTime.getText() + "&theater_id_order=" + tfTheater.getText());

            String response2;
            response2 = cm.sendGetRequest("returnMovieSchema/?Moviename=" + tfName.getText());

            parseMovies(response2);
            System.out.println(response2);

            String trimmedResponse = trimResponse(response2);

            System.out.println("trimmed version: " + trimmedResponse);

            Movies[] movieArray = gson.fromJson(trimmedResponse, Movies[].class);
            System.out.println("movieArray: " + movieArray[0]);
            System.out.println("first movieName: " + movieArray[1].getMovie_name());
            System.out.println(Arrays.toString(movieArray));

            for (int i = 0; i < movieArray.length; i++){
                Schedule insert = new Schedule(movieArray[i].getMovie_name(), movieArray[i].getMovie_datetime(), movieArray[i].getTheater_id(), movieArray[i].getSeats_avalible());

                System.out.println("index: " + Arrays.toString(movieArray) + i);
                table.add(insert);
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

    public void parseMovies(String moviesAsString){
        Gson gson = new Gson();

        Movies movies = gson.fromJson(moviesAsString, Movies.class);

        ObservableList<Schedule> table = FXCollections.observableArrayList();

        movieNameColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>(movies.getMovie_name()));
        movieTimeColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>(movies.getMovie_datetime()));
        movieTheaterColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>(String.valueOf(movies.getTheater_id())));
        seatsAvailableColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>(movies.getSeats_avalible()));

    }

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

