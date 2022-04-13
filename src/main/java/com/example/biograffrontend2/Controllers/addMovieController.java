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
import java.util.List;

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



            String json = "{'hora': 'TheGentlemen', 'kuk': '2021-04-13', 'theater_id': 2, 'seats_avalible': 59}";

            Gson gson2 = new Gson();
            Test emp = gson2.fromJson("{'kuk': 'TheGentlemen', 'edvinlitenkuk': '2021-04-13', 'theater_id': 2}", Test.class);
            System.out.println("emp: " + emp);

           Test host = new Test("A", "B", "C", "D");

           System.out.println(host);
           Gson gson3 = new Gson();

           String hej = String.valueOf(host);

           Test emp3 = gson3.fromJson(hej, Test.class);

           System.out.println(emp3);




            //Movies<String> movieList = new List<>;
            Movies[] movieArray = gson2.fromJson(trimmedResponse, Movies[].class);
            System.out.println("movieArray: " + movieArray[0]);
            System.out.println(Arrays.toString(movieArray));



        //System.out.println(response);

        /*Schedule schedule = new Schedule(tfName.getText(), tfTime.getText(), tfTheater.getText());

        table.add(schedule);*/

        // Vi ska inte lägga in nåt i table.add(schedule); utan det användaren skriver in ska direkt in i
            // databasen. Sen när metode

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

        movieNameColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>(movies.getMoviename()));
        movieTimeColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>(movies.getDateTime()));
        movieTheaterColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>(String.valueOf(movies.getTheaterId())));
        seatsAvailableColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>(movies.getSeatsAvailable()));

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

