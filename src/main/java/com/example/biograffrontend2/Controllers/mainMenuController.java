package com.example.biograffrontend2.Controllers;

import com.example.biograffrontend2.Application;
import com.example.biograffrontend2.ConnectionManager;
import com.example.biograffrontend2.Movies;
import com.example.biograffrontend2.Schedule;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.*;

public class mainMenuController {

    @FXML
    private Label workingLabel;
    @FXML
    public static ImageView currentImage;
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


    public String response;
    public String tom = "@tom";


    public mainMenuController() {

    }


    @FXML
    protected void closeButtonClicked() {
        System.exit(0);

    }


    @FXML
    protected void adminLoginButtonClicked(ActionEvent event) throws IOException {
        Application a = new Application();
        a.changeScene("adminLogin.fxml");

    }


    @FXML
    protected void movieButtonClicked(MouseEvent event) throws IOException {
        Platform.runLater(()->{
            ImageView currentImage = (ImageView) event.getSource();
            //System.out.println(currentImage);

            if(currentImage.getId().equals("brokebackImage")){
                String Moviename = "BrokebackMountain";
                Platform.runLater(()->{

                    ConnectionManager cm = new ConnectionManager();

                    response = cm.sendGetRequest("returnMovieSchema/?Moviename=" + Moviename);
                    parseMovies(response);
                    //System.out.println(response);

                });

            }if(currentImage.getId().equals("spidermanImage")){
                String Moviename = "Spiderman";
                Platform.runLater(()->{

                    ConnectionManager cm = new ConnectionManager();

                    String response = cm.sendGetRequest("returnMovieSchema/?Moviename=" + Moviename);

                    parseMovies(response);

                    System.out.println(response);
                });

            }if(currentImage.getId().equals("snatchImage")){
                System.out.println("Snatch");
            }if(currentImage.getId().equals("theGentlemenImage")){
                System.out.println("The Gentlemen");
            }
            try {
                Application m = new Application();
                m.changeScene("movieSchedule.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }


        });

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
    protected void movieMouseEnteredEvent(MouseEvent event) {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(+0.1);
        ImageView currentImage = (ImageView) event.getSource();
        currentImage.setEffect(colorAdjust);

    }


    // Förse tabellen med värden:



    @FXML
    protected void movieMouseExitedEvent(MouseEvent event) {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.1);
        ImageView currentImage = (ImageView) event.getSource();
        currentImage.setEffect(colorAdjust);

    }


    @FXML
    public static void addTextLimiter(final TextField tf, final int maxLength) {
        Platform.runLater(()->{

        tf.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                if (tf.getText().length() > maxLength) {
                    String s = tf.getText().substring(0, maxLength);
                    tf.setText(s);
                }
            }
        });
        });
    }

/*    @FXML
    public ObservableList<Schedule> getBooksList(){
        ObservableList<Schedule> bookList = FXCollections.observableArrayList();

        Schedule books;
        books = new Schedule("A", "B", "C", "D");
        bookList.add(books);
        Schedule cooks;
        cooks = new Schedule("E", "F", "G", "H");
        bookList.add(cooks);
        System.out.println(bookList);

        return bookList;
    }
    @FXML
    public void showBooks(){

        System.out.println("Hej");
        ObservableList<Schedule> list = getBooksList();
        System.out.println(list.toString());

                alo.setCellValueFactory(new PropertyValueFactory<Schedule, String>("a"));
                b.setCellValueFactory(new PropertyValueFactory<Schedule, String>("b"));
                c.setCellValueFactory(new PropertyValueFactory<Schedule, String>("c"));
                d.setCellValueFactory(new PropertyValueFactory<Schedule, String>("d"));

                kuk.setItems(list);
    }*/


}