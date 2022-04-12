package com.example.biograffrontend2.Controllers;

import com.example.biograffrontend2.Application;
import com.example.biograffrontend2.ConnectionManager;
import com.example.biograffrontend2.Movies;
import com.example.biograffrontend2.Schedule;
import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class movieScheduleController {

    @FXML
    private Button refreshButton;
    @FXML
    private Button confirmButton;
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


    public String response;
    public String tom = "@tom";

    @FXML
    protected void movieSchemaBackButtonClicked(ActionEvent event) throws IOException {
        Application m = new Application();
        m.changeScene("mainMenu.fxml");
    }

    @FXML
    protected void closeButtonClicked() {
        System.exit(0);

    }

    @FXML
    protected void refreshButtonClicked(ActionEvent event) throws IOException {
        showTable();

    }
    public void parseMovies(String moviesAsString){
        Gson gson = new Gson();

        Movies movies = gson.fromJson(moviesAsString, Movies.class);

        movieNameColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>(movies.getMoviename()));
        movieTimeColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>(movies.getDateTime()));
        movieTheaterColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>(String.valueOf(movies.getTheaterId())));
        seatsAvailableColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>(movies.getSeatsAvailable()));

    }

    @FXML
    public ObservableList<Schedule> populateTable(){
        ObservableList<Schedule> table = FXCollections.observableArrayList();

        Schedule schedule;
        schedule = new Schedule("A", "B", "C", "D");
        table.add(schedule);


        return table;
    }
    @FXML
    public void showTable(){
        ObservableList<Schedule> list = populateTable();


        movieNameColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("a"));
        movieTimeColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("b"));
        movieTheaterColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("c"));
        seatsAvailableColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("d"));
        tableView.setItems(list);

    }


}
