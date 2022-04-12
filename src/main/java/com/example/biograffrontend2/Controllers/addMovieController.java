package com.example.biograffrontend2.Controllers;

import com.example.biograffrontend2.Application;
import com.example.biograffrontend2.Schedule;
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

    @FXML
    protected void refreshButton(ActionEvent event) throws IOException {
        showTable();
    }

    @FXML
    protected void addButton(ActionEvent event) throws IOException {

        //

        clearColums();
        showTable();
    }

    @FXML
    protected void deleteButton(ActionEvent event) throws IOException {



        clearColums();
        showTable();
    }

}