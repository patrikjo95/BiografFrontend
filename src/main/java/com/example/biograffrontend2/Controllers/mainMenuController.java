package com.example.biograffrontend2.Controllers;

import com.example.biograffrontend2.Application;
import com.example.biograffrontend2.ConnectionManager;
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
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class mainMenuController {

    @FXML
    private Label workingLabel;
    @FXML
    private TableView<Schedule> kuk;
    @FXML
    private TableColumn<Schedule, String> alo;
    @FXML
    private TableColumn<Schedule, String> b;
    @FXML
    private TableColumn<Schedule, String> c;
    @FXML
    private TableColumn<Schedule, String> d;

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
        Application m = new Application();

        if(currentImage.getId().equals("brokebackImage")){
            String Moviename = "BrokebackMountain";
            Platform.runLater(()->{

                ConnectionManager cm = new ConnectionManager();

                response = cm.sendGetRequest("returnMovieSchema/?Moviename=" + Moviename);


                System.out.println(response);
                String movieName = response.split("movie_name\":|,")[1];
                String movieDateTime = response.split("movie_datetime\":|,")[2];
                String theaterId = response.split("theater_id\":|,")[3];
                String seatsAvailable = response.split("seats_avalible\":|,")[4];






                //System.out.println("Split respone: " + Arrays.toString(splitRespone));

                System.out.println(movieName);
                System.out.println(movieDateTime);
                System.out.println(theaterId);
                System.out.println(seatsAvailable);


            });

        }if(currentImage.getId().equals("spidermanImage")){
                String Moviename = "Spiderman";
                Platform.runLater(()->{

                    ConnectionManager cm = new ConnectionManager();

                    String response = cm.sendGetRequest("returnMovieSchema/?Moviename=" + Moviename);

                    System.out.println(response);
                });

        }if(currentImage.getId().equals("snatchImage")){
            System.out.println("Snatch");
        }if(currentImage.getId().equals("theGentlemenImage")){
            System.out.println("The Gentlemen");
        }
            try {
                m.changeScene("movieSchedule.fxml");
                //showBooks();
            } catch (IOException e) {
                e.printStackTrace();
            }


        });

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
