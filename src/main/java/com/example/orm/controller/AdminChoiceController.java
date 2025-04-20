package com.example.orm.controller;

import com.example.orm.utils.WindowUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class AdminChoiceController {
    @FXML
    private AnchorPane pane;

    @FXML
    void gotoBack(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("Landing", pane);
    }

    @FXML
    void gotoTherepists(ActionEvent event) {

    }

    @FXML
    void gotoTherepyProgramme(ActionEvent event) {

    }
}
