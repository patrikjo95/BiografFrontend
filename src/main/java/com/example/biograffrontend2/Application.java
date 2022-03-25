package com.example.biograffrontend2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Application extends javafx.application.Application {
    private static Stage newStage;

    public Application() {
    }

    public void start(Stage stage) throws IOException {
        newStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("movieMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource(fxml)));
        newStage.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}