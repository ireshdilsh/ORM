package com.example.orm.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class WindowUtils {
    public void navigateTo(String path, AnchorPane pane) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/" + path + ".fxml"));
        pane.getChildren().setAll(anchorPane);
    }
}
