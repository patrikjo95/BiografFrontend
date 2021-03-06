package com.example.biograffrontend2.Controllers;

import com.example.biograffrontend2.Application;
import com.example.biograffrontend2.Movies;
import com.example.biograffrontend2.Schedule;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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


    @FXML
    public ObservableList<Schedule> populateTable(){
        ObservableList<Schedule> table = FXCollections.observableArrayList();

        Schedule schedule;
        schedule = new Schedule("A", "B", "C");
        table.add(schedule);

        return table;
    }

    /**
     * skall ta värden från vilken film-knapp man klickade på och lägga in i tableview
     */
    @FXML
    public void showTable(){
        ObservableList<Schedule> list = populateTable();


        movieNameColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("a"));
        movieTimeColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("b"));
        movieTheaterColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("c"));
        tableView.setItems(list);

    }


}
