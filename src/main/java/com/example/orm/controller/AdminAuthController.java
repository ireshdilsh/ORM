package com.example.orm.controller;

import com.example.orm.utils.WindowUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

public class AdminAuthController {
    @FXML
    private AnchorPane adminLoginAuthPane;

    @FXML
    private TextField emailTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    void backLanding(ActionEvent event) throws Exception{
        new WindowUtils().navigateTo("LandingView", adminLoginAuthPane);
    }

    @FXML
    void gotoChoicesView(ActionEvent event) {
        if (emailTxt.getText().isEmpty()) {
            new Alert(AlertType.ERROR,"Email Address Cannot be Null").show();
        }

        if (passwordTxt.getText().isEmpty()) {
            new Alert(AlertType.ERROR,"Password Cannot be Null").show();
        }
    }
}
