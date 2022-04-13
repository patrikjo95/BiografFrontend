package com.example.biograffrontend2.Controllers;

import com.example.biograffrontend2.Application;
import com.example.biograffrontend2.ConnectionManager;
import com.example.biograffrontend2.Schedule;
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
    @FXML
    private TextField tfSeats;

    public String response;

    @FXML
    protected void populateTextField() {
        try {
            tfName.setText(tableView.getSelectionModel().getSelectedItem().getA());
            tfTime.setText(tableView.getSelectionModel().getSelectedItem().getB());
            tfTheater.setText(tableView.getSelectionModel().getSelectedItem().getC());
            tfSeats.setText(tableView.getSelectionModel().getSelectedItem().getD());
        }
        catch (NullPointerException npe) {
        }
    }

    private void clearColums() {
        showTable();
        tfName.clear();
        tfTime.clear();
        tfTheater.clear();
        tfSeats.clear();
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

        Schedule schedule;
        schedule = new Schedule("A", "B", "C", "D");
        Schedule schedule1 = new Schedule("Hej", "ost", "röv", "kiss");
        table.add(schedule);
        table.add(schedule1);

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

    @FXML
    protected void refreshButton(ActionEvent event) throws IOException {

        showTable();

    }

    @FXML
    protected void addButton(ActionEvent event) throws IOException {
        Platform.runLater(()->{

        ConnectionManager cm = new ConnectionManager();

        response = cm.sendGetRequest("addMovie/?movie_name=" + tfName.getText() + "&movie_datetime=" + tfTime.getText() + "&theater_id_order=" + tfTheater.getText());
        ObservableList<Schedule> table = FXCollections.observableArrayList();

        System.out.println(response);
        Schedule schedule2 = new Schedule(tfName.getText(), tfTime.getText(), tfTheater.getText(), tfSeats.getText());

        table.add(schedule2);

        clearColums();
        showTable();
        });

    }

    @FXML
    protected void deleteButton(ActionEvent event) throws IOException {



        clearColums();
        showTable();
    }

}