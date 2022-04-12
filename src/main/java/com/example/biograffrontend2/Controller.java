package com.example.biograffrontend2;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller {


    @FXML
    private TextField passwordField;
    @FXML
    private TextField userNameField;
    @FXML
    private Label loginErrorLabel;
    @FXML
    private Label loginUserLabel;


    private DatePicker datePicker;
    @FXML
    private Label workingLabel;
    @FXML
    private TableColumn<Schedule, String> alo;
    @FXML
    private TableColumn<Schedule, String> b;
    @FXML
    private TableColumn<Schedule, String> c;
    @FXML
    private TableColumn<Schedule, String> d;




    public Controller() {

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
        System.out.println(currentImage);
        Application m = new Application();

        if(currentImage.getId().equals("brokebackImage")){
            Platform.runLater(()->{

                ConnectionManager cm = new ConnectionManager();

                String response = cm.sendGetRequest("test");
                System.out.println("brokeback");
            });
        }if(currentImage.getId().equals("spidermanImage")){
            System.out.println("Spiderman");
        }if(currentImage.getId().equals("snatchImage")){
            System.out.println("Snatch");
        }if(currentImage.getId().equals("theGentlemenImage")){
            System.out.println("The Gentlemen");
        }
            try {
                m.changeScene("movieSchedule.fxml");
                showBooks();
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

    @FXML
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
    }



}
