package com.example.orm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Initializer extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Landing.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("SESSIONS");
        stage.show();
    }

    public static void main(String[] args) {
        
        launch();
    }
}