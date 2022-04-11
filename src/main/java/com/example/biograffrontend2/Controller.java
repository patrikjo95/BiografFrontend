package com.example.biograffrontend2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/biograf";
    static final String USER = "newuser1";
    static final String PASS = "password";

    @FXML
    private TextField passwordField;
    @FXML
    private TextField userNameField;
    @FXML
    private Label loginErrorLabel;
    @FXML
    private Label loginUserLabel;
    @FXML
    private TextField adminNameField;
    @FXML
    private TextField adminPhoneField;
    @FXML
    private TextField adminUsernameField;
    @FXML
    private TextField adminPassword1Field;
    @FXML
    private TextField adminPassword2Field;
    @FXML
    private Label adminLoginErrorLabel;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Label workingLabel;
    @FXML
    private TableView schedule;
    @FXML
    private TableColumn movieNameColumn;
    @FXML
    private TableColumn movieTimeColumn;
    @FXML
    private TableColumn movieTheaterColumn;
    @FXML
    private TableColumn seatsAvalibleColumn;


    public String response;
    String tom = "@tom";

    public Controller() {

    }


    @FXML
    protected void closeButtonClicked() {
        System.exit(0);
    }


    @FXML
    protected void adminButtonClicked(ActionEvent event) throws IOException {
        Application a = new Application();
        a.changeScene("adminLogin.fxml");

    }

    @FXML
    protected void loginButtonClicked(ActionEvent event) throws IOException {
        /*Platform.runLater(() -> {
            ConnectionManager cm = new ConnectionManager();
            String username = userNameField.getText();
            String password = passwordField.getText();

            response = cm.sendGetRequest("staffLogin/?username=" + username + "&password=" + password + "&@tom=" + tom);
            //adminLoginErrorLabel.setVisible(false);

            if(response.contains("Incorrect")){
                loginErrorLabel.setVisible(true);
                loginErrorLabel.setText("Incorrect login");
                userNameField.clear();
                passwordField.clear();
            }else{
                Application m = new Application();
                try {
                    m.changeScene("adminSchema.fxml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });*/
        Application m = new Application();
        m.changeScene("adminSchema.fxml");

    }


    @FXML
    protected void adminLogoutButtonClicked(ActionEvent event) throws IOException {
        Application m = new Application();
        m.changeScene("adminLogin.fxml");
    }

    @FXML
    protected void addAdminButtonClicked(ActionEvent event) throws IOException {
        Application m = new Application();
        m.changeScene("createAdmin.fxml");
    }

    @FXML
    protected void addMovieButtonClicked(ActionEvent event) throws IOException {
        Application m = new Application();
        m.changeScene("addMovie.fxml");
    }

    @FXML
    protected void movieButtonClicked(MouseEvent event) throws IOException {
        ImageView currentImage = (ImageView) event.getSource();
        System.out.println(currentImage);
        Application m = new Application();

        if(currentImage.getId().equals("brokebackImage")){
            new Thread(()->{
                ConnectionManager cm = new ConnectionManager();

                String response = cm.sendGetRequest("test");
                System.out.println("brokeback");
            }).start();
        }if(currentImage.getId().equals("spidermanImage")){
            System.out.println("Spiderman");
        }if(currentImage.getId().equals("snatchImage")){
            System.out.println("Snatch");
        }if(currentImage.getId().equals("theGentlemenImage")){
            System.out.println("The Gentlemen");
        }
        m.changeScene("movieSchedule.fxml");

    }

    @FXML
    protected void movieMouseEnteredEvent(MouseEvent event) {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(+0.1);
        ImageView currentImage = (ImageView) event.getSource();
        currentImage.setEffect(colorAdjust);

    }

    @FXML
    public ObservableList<Schedule> scheduleObservableList() {
        ObservableList<Schedule> schedule = FXCollections.observableArrayList();
        ConnectionManager connectionmanager = new ConnectionManager();




        return null;

    }

    @FXML
    protected void movieMouseExitedEvent(MouseEvent event) {
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setBrightness(-0.1);
        ImageView currentImage = (ImageView) event.getSource();
        currentImage.setEffect(colorAdjust);

    }

    @FXML
    protected void movieSchemaBackButtonClicked(ActionEvent event) throws IOException {
        Application m = new Application();
        m.changeScene("mainMenu.fxml");
    }

    @FXML
    protected void addMovieBackButtonClicked(ActionEvent event)throws IOException{
        Application m = new Application();
        m.changeScene("adminSchema.fxml");
    }

    @FXML
    protected void adminLoginBackButtonClicked(ActionEvent event)throws IOException{
        Application m = new Application();
        m.changeScene("mainMenu.fxml");
    }

    @FXML
    protected void createAdminBackButtonClicked(ActionEvent event)throws IOException{
        Application m = new Application();
        m.changeScene("adminSchema.fxml");
    }


    @FXML
    private void createAdminButtonClicked(ActionEvent event){
        Platform.runLater(() -> {
            ConnectionManager cm = new ConnectionManager();
            String adminName = adminNameField.getText();
            String phone = adminPhoneField.getText();
            String username = adminUsernameField.getText();
            String password = adminPassword1Field.getText();

            if(Objects.equals(adminPassword1Field.getText(), adminPassword2Field.getText())){

            response = cm.sendGetRequest("addStaff/?adminName=" + adminName + "&phone=" + phone + "&username=" + username + "&password=" + password + "&@tom=" + tom);

            System.out.println("response: " + response);
            adminLoginErrorLabel.setVisible(false);

                if(response.contains("number")){
                    adminLoginErrorLabel.setText("Incorrect phone number");
                    adminLoginErrorLabel.setVisible(true);
                    System.out.println("Fel telefonnummer");

                }else if(response.contains("username")){
                    adminLoginErrorLabel.setText("That user already exists");
                    adminLoginErrorLabel.setVisible(true);
                    System.out.println("duplicate username");

                }else if(adminPassword1Field.getText().equals(adminPassword2Field.getText())) {
                    Application m = new Application();
                    try {
                        m.changeScene("adminSchema.fxml");
                        //loginUserLabel.setText("Inloggad som: " + userNameField.getText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }else{
                adminLoginErrorLabel.setVisible(true);
                adminLoginErrorLabel.setText("Incorrect password, please try again.");
            }

        });

    }

    @FXML
    private void getDate() {
        LocalDate localDate = datePicker.getValue();
        workingLabel.setVisible(true);
        //TODO denna skall hämta ifall man jobbar eller ej, visa vilken tid man jobbar samt var... DateCellFactory funkar inte...
        workingLabel.setText(String.valueOf(localDate));

        List<LocalDate> exempelDagar = new ArrayList<>();
        exempelDagar.add(LocalDate.of(2022, Month.MARCH, 30));
        exempelDagar.add(LocalDate.of(2022, Month.MARCH, 29));
        exempelDagar.add(LocalDate.of(2022, Month.MARCH, 28));
        exempelDagar.add(LocalDate.of(2022, Month.APRIL, 1));
        System.out.println(exempelDagar);

        datePicker.setDayCellFactory(new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(DatePicker param) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);

                        if (!empty && item != null) {
                            if (exempelDagar.contains(item)) {
                                this.setStyle("-fx-background-color: pink");
                            }
                        }
                    }
                };
            }
        });

    }

    private ImageView getCurrentImage(MouseEvent event){
        return null;
    }


}
